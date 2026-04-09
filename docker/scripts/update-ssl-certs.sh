#!/bin/bash
set -euo pipefail

CERT_NAME="studyplanner"
EMAIL="dgrachovsd@gmail.com"
DOMAINS=(
    "studyplannter.wiresnchains.com"
)

# Build domain args

DOMAIN_ARGS=()
for DOMAIN in "${DOMAINS[@]}"; do
    DOMAIN_ARGS+=(-d "$DOMAIN")
done

NGINX_STATUS=$(docker compose ps --status running nginx 2>/dev/null) || {
    echo "ERROR: Failed to check nginx status." >&2
    exit 1
}

if ! echo "$NGINX_STATUS" | grep -q "nginx"; then
    echo "ERROR: nginx is not running. Cannot complete certificate issuance." >&2
    exit 1
fi

echo "Issuing certificate for: ${DOMAINS[*]}"

docker compose run --rm certbot certonly \
    --cert-name "$CERT_NAME" \
    --webroot -w /var/www/certbot \
    "${DOMAIN_ARGS[@]}" \
    --email "$EMAIL" \
    --agree-tos \
    --non-interactive \
    --no-eff-email

echo "Copying cert files to nginx..."

docker compose run --rm --entrypoint sh certbot -c \
    "mkdir -p /etc/shared_certs/live/$CERT_NAME && \
    cp -L /etc/letsencrypt/live/$CERT_NAME/fullchain.pem /etc/shared_certs/live/$CERT_NAME/fullchain.pem && \
    cp -L /etc/letsencrypt/live/$CERT_NAME/privkey.pem /etc/shared_certs/live/$CERT_NAME/privkey.pem"

echo "Reloading nginx configuration..."

docker compose exec nginx nginx -s reload

echo "Restarting stalwart container..."

docker compose restart stalwart # stalwart-cli reload doesn't work if ran from the same network

echo "Done!"
