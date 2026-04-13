(function() {
    const fly = document.getElementById('fly');
    const canvas = document.getElementById('fly-trail');
    const ctx = canvas.getContext('2d');

    function resize() {
        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;
    }
    resize();
    window.addEventListener('resize', resize);

    let x = window.innerWidth / 2, y = window.innerHeight / 2;
    let vx = 0, vy = 0;
    let targetX = x, targetY = y;
    let buzzTimer = 0;
    let trail = [];
    let buzzPhase = 0;
    let mouseX = -999, mouseY = -999;
    const SCARE_DIST = 120;
    const REST_DIST  = 25;

    let state = 'flying';
    let restTimer = 0;

    function newTarget() {
        targetX = 60 + Math.random() * (window.innerWidth  - 120);
        targetY = 60 + Math.random() * (window.innerHeight - 120);
    }
    newTarget();

    window.addEventListener('mousemove', function(e) {
        mouseX = e.clientX;
        mouseY = e.clientY;
    });

    function distToMouse() {
        const dx = mouseX - x, dy = mouseY - y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    function tick() {
        buzzPhase += 0.18;

        const mouseDist = distToMouse();

        if (mouseDist < SCARE_DIST) {
            if (state === 'resting') {
                state = 'flying';
                restTimer = 0;
                newTarget();
            }
            const ax = x - mouseX, ay = y - mouseY;
            const am = Math.sqrt(ax*ax + ay*ay) || 1;
            vx += (ax / am) * 1.2;
            vy += (ay / am) * 1.2;
        }

        if (state === 'resting') {
            vx *= 0.7;
            vy *= 0.7;
            restTimer--;
            if (restTimer <= 0) {
                state = 'flying';
                newTarget();
            }
        } else {
            const dx = targetX - x, dy = targetY - y;
            const dist = Math.sqrt(dx*dx + dy*dy) || 1;

            if (dist < REST_DIST && mouseDist > SCARE_DIST) {
                state = 'resting';
                restTimer = 120 + Math.floor(Math.random() * 180);
                vx *= 0.3;
                vy *= 0.3;
            } else if (buzzTimer > 0) {
                vx += (Math.random() - 0.5) * 2;
                vy += (Math.random() - 0.5) * 2;
                buzzTimer--;
            } else {
                vx += (dx / dist) * 0.3;
                vy += (dy / dist) * 0.3;
                if (dist < 80 && Math.random() < 0.01) {
                    buzzTimer = 20 + Math.floor(Math.random() * 40);
                }
            }
        }

        const maxSpd = state === 'resting' ? 1 : 5;
        const spd = Math.sqrt(vx*vx + vy*vy);
        if (spd > maxSpd) { vx = vx/spd*maxSpd; vy = vy/spd*maxSpd; }

        x = Math.max(20, Math.min(window.innerWidth  - 30, x + vx));
        y = Math.max(20, Math.min(window.innerHeight - 30, y + vy));

        const moving = spd > 0.5;
        const angle  = moving ? Math.atan2(vy, vx) * 180 / Math.PI : 0;
        const wobble = Math.sin(buzzPhase * 3.5) * (moving ? 3 : 1);

        fly.style.left      = (x - 18) + 'px';
        fly.style.top       = (y - 18) + 'px';
        fly.style.transform = 'rotate(' + (angle + wobble) + 'deg)';

        if (moving) trail.push({x, y});
        if (trail.length > 80) trail.shift();

        ctx.clearRect(0, 0, canvas.width, canvas.height);
        for (let i = 1; i < trail.length; i++) {
            ctx.beginPath();
            ctx.moveTo(trail[i-1].x, trail[i-1].y);
            ctx.lineTo(trail[i].x,   trail[i].y);
            ctx.strokeStyle = 'rgba(60,40,20,' + (i / trail.length * 0.4) + ')';
            ctx.lineWidth   = 0.8;
            ctx.stroke();
        }

        requestAnimationFrame(tick);
    }
    tick();
}());