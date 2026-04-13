let focusDuration = 25 * 60;
let shortBreak = 5 * 60;
let longBreak = 10 * 60;

let duration = focusDuration;
let remaining = duration;
let interval = null;

let cycle = 0;
let isBreak = false;

const timeDisplay = document.getElementById("time");
const progressCircle = document.querySelector(".progress");
const modeDisplay = document.getElementById("mode");
const circle = document.getElementById("circle");

const circumference = 2 * Math.PI * 70;
progressCircle.style.strokeDasharray = circumference;

// Toggle
document.getElementById("toggleBtn").onclick = () => {
  const box = document.getElementById("timerBox");
  box.style.display = box.style.display === "none" ? "block" : "none";
};

// Klik = start/pauze
circle.addEventListener("click", () => {
  if (interval) pauseTimer();
  else startTimer();
});

function updateDisplay() {
  let min = Math.floor(remaining / 60);
  let sec = remaining % 60;

  timeDisplay.textContent =
    String(min).padStart(2, '0') + ":" +
    String(sec).padStart(2, '0');

  let progress = remaining / duration;
  let offset = circumference * (1 - progress);
  progressCircle.style.strokeDashoffset = offset;
}

function nextSession() {
  if (!isBreak) {
    cycle++;
    isBreak = true;

    if (cycle % 4 === 0) {
      duration = longBreak;
      modeDisplay.textContent = "Lange pauze";
      progressCircle.style.stroke = "#0d6efd"; // blauw
    } else {
      duration = shortBreak;
      modeDisplay.textContent = "Korte pauze";
      progressCircle.style.stroke = "#198754"; // groen
    }
  } else {
    isBreak = false;
    duration = focusDuration;
    modeDisplay.textContent = "Focus";
    progressCircle.style.stroke = "#dc3545"; // rood
  }

  remaining = duration;
  updateDisplay();
}

function startTimer() {
  if (interval) return;

  interval = setInterval(() => {
    if (remaining > 0) {
      remaining--;
      updateDisplay();
    } else {
      clearInterval(interval);
      interval = null;
      nextSession();
      startTimer();
    }
  }, 1000);
}

function pauseTimer() {
  clearInterval(interval);
  interval = null;
}


function resetTimer() {
  pauseTimer();
  cycle = 0;
  isBreak = false;
  duration = focusDuration;
  remaining = duration;
  modeDisplay.textContent = "Focus";
  progressCircle.style.stroke = "#dc3545";
  updateDisplay();
}

// Drag
let isDragging = false;
let offsetX, offsetY;
const box = document.getElementById("timerBox");

box.addEventListener("mousedown", (e) => {
  isDragging = true;
  offsetX = e.clientX - box.offsetLeft;
  offsetY = e.clientY - box.offsetTop;
});

document.addEventListener("mousemove", (e) => {
  if (isDragging) {
    box.style.left = (e.clientX - offsetX) + "px";
    box.style.top = (e.clientY - offsetY) + "px";
  }
});

document.addEventListener("mouseup", () => {
  isDragging = false;
});

updateDisplay();
