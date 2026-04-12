#!/bin/bash
set -eou pipefail

CERT_NAME="tomcat"
EMAIL="postmaster@senora.me"
DOMAINS=(
    "studyplanner.wiresnchains.com"
)

DOMAIN_ARGS=()
for DOMAIN in "${DOMAINS[@]}"; do
    DOMAIN_ARGS+=(-d "$DOMAIN")
done

echo "Stopping Tomcat..."
docker compose stop tomcat

echo "Requesting certificates..."
docker compose run --rm -p 80:80 certbot certonly \
    --cert-name "$CERT_NAME" \
    --standalone \
    "${DOMAIN_ARGS[@]}" \
    --email "$EMAIL" \
    --agree-tos \
    --non-interactive \
    --no-eff-email

echo "Starting Tomcat..."
docker compose start tomcat
