let count = 0;
let clickBtn = document.getElementById("clickBtn");
let clickSpan = document.getElementById("click");
const base = document.body.dataset.base;

clickBtn.addEventListener("click", () => {
	if (count >= 50) {
		count += 2;
	} else {
    count++;
	}
    clickSpan.innerHTML = count;
    if (count === 25) clickImg();
	if (count === 100) clickPork();
    if (count % 20 === 0) {
        let a = Math.random() * 255;
        let b = Math.random() * 255;
        let c = Math.random() * 255;

        let d = `rgb(${a}, ${b}, ${c})`;
        clickSpan.style.color = d;
    }
});


function clickImg() {
    for (let i = 0;i < 50;i++) {
        let img = document.createElement("img");
        img.src = base + "img/tungtung.webp"
        img.classList.add("flying-img");

        img.style.left = Math.random() * 100 + "vw";
        img.style.top = Math.random() * 150 + "vh";

        img.style.width = (50 + Math.random() * 50) + "px";

        document.body.appendChild(img);

        setTimeout(() => {
            img.remove();
        }, 4000);
    }
}

function clickPork() {
    for (let i = 0;i < 50;i++) {
        let img = document.createElement("img");
        img.src = base + "img/pork.jpg";
        img.classList.add("flying-img");

        img.style.left = Math.random() * 100 + "vw";
        img.style.top = Math.random() * 150 + "vh";

        img.style.width = (120 + Math.random() * 50) + "px";

        document.body.appendChild(img);

        setTimeout(() => {
            img.remove();
        }, 4000);
    }
}