function rollTumbleweed() {
    var tumbleweed = document.getElementById('tumbleweed');

    tumbleweed.classList.add('rolling');

    setTimeout(function () {
        tumbleweed.classList.remove('rolling');
        scheduleNext();
    }, 3000);
}

function scheduleNext() {
    var delay = (1 * 30 * 1000) + (Math.random() * 30000 - 10000);
    setTimeout(rollTumbleweed, delay);
}

scheduleNext();