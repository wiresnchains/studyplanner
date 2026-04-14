function toonRandomGif() {
    const gif = document.getElementById("hair");
    if (!gif) return;
	
	gif.style.opacity = "1";

    const maxX = window.innerWidth - gif.offsetWidth;
    const maxY = window.innerHeight - gif.offsetHeight;
	

    gif.style.left = `${Math.random() * maxX}px`;
    gif.style.top = `${Math.random() * maxY}px`;
	
	const rot = Math.random() * 360;
	gif.style.transform = `rotate(${rot}deg)`;

    setTimeout(() => {
        gif.style.opacity = "0";
    }, 10000);
}

function randomSpawn() {
    toonRandomGif();
    const next = Math.random() * 4000 + 11000;
    setTimeout(randomSpawn, next);
}

window.addEventListener("load", () => {
    randomSpawn();
});