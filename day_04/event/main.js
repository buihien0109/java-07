// Sử dụng HTML-attribute
function sayHello() {
    alert("Xin chào các bạn 1");
}

// Sử dụng DOM property
const btn2 = document.getElementById("btn-2");
// btn2.onclick = function() {
//     alert("Xin chào các bạn 2");
// }

btn2.onclick = sayHello2;

function sayHello2() {
    alert("Xin chào các bạn 2");
}

// Sử dụng addEventListener
const btn3 = document.getElementById("btn-3");
// btn3.addEventListener("click", function() {
//     alert("Xin chào các bạn 3");
// })

btn3.addEventListener("click", sayHello3)
function sayHello3() {
    alert("Xin chào các bạn 3");
}