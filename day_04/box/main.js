
   
let colors = ["#3498db", "#9b59b6", "#e74c3c", "#2c3e50", "#d35400"];
function renderBox() {
    for (let i = 0; i < colors.length; i++) {
        let box = document.createElement("div");
        box.className = "box";
        box.style.backgroundColor = colors[i];
        const wrap = document.querySelector(".wrap");
        wrap.appendChild(box);

    }
    const points = document.querySelector(".points");
    const lengthBox = document.getElementsByClassName("box");
    points.innerText = lengthBox.length;
    const Box = document.querySelectorAll(".box");
    for (let i = 0; i < Box.length; i++) {
        Box[i].onclick = function () {
            Box[i].remove();
            points.innerHTML = lengthBox.length;
        }
    }
}
renderBox();
const btn = document.getElementById("btn");
btn.addEventListener("click", function () {
    renderBox();
});
