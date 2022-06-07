// // Lắng nghe sự kiện keyup
// document.addEventListener("keyup", function () {
//     console.log("keyup");
// });

// // Lắng nghe sự kiện keypress
// document.addEventListener("keypress", function () {
//     console.log("keypress");
// });

// Lắng nghe sự kiện keydown
// document.addEventListener("keydown", function (event) {
//     if(event.keyCode == 13) {
//         console.log("Còn cái nịt");
//     } else {
//         console.log("Nhặt được 20 củ");
//     }
// });

const inputEl = document.querySelector("input");
inputEl.addEventListener("keydown", function(event) {
    if(event.keyCode == 13) {
        let value = inputEl.value;
        // let value = event.target.value;
        alert(`Từ khóa bạn vừa nhập là : ${value}`);
    }
})

inputEl.addEventListener("change", function() {
    inputEl.value = inputEl.value.toUpperCase();
})

inputEl.addEventListener("focus", function() {
    inputEl.value = inputEl.value.toLowerCase();
})
