document.addEventListener("DOMContentLoaded", () => {
    const eye = document.getElementById("eye");

    function showEye() {
        const width = window.innerWidth;
        const height = window.innerHeight;

        const x = Math.random() * (width - 100);
        const y = Math.random() * (height - 100);

        eye.style.left = x + "px";
        eye.style.top = y + "px";

        eye.style.display = "block";

        setTimeout(() => {
            eye.style.display = "none";
        }, 2000 + Math.random() * 2000);
    }

    function randomEyeLoop() {
        const delay = 8000 + Math.random() * 12000;

        setTimeout(() => {
            showEye();
            randomEyeLoop();
        }, delay);
    }

    randomEyeLoop();
});