// document.addEventListener('mousedown', function () {
//     console.log('mousedown');
// })

// document.addEventListener('mousemove', function () {
//     console.log('mousemove');
// })

// document.addEventListener('mouseup', function () {
//     console.log('mouseup');
// })

// document.addEventListener('click', function (event) {
//     console.log(event);
// })

document.addEventListener('mousemove', function (event) {
    // Xóa hình tròn trước đó đi
    const boxEl = document.querySelector(".box");
    if(boxEl) {
        boxEl.parentElement.removeChild(boxEl)
    }

    // B1 : Tạo box
    let box = document.createElement("div");
    box.classList.add("box");

    // B2 : Set vị trí cho box
    box.style.left = `${event.offsetX - 100}px`;
    box.style.top = `${event.offsetY - 100}px`;

    // B3 : Gán vào dom
    document.body.appendChild(box);
})
