const heading = document.getElementById("heading");
console.log(heading);

// querySelector
const para2 = document.querySelector(".para");
console.log(para2);

const para3 = document.querySelector("p:nth-child(4)")
console.log(para3);

// body > ul
const ul2 = document.querySelector(".box + ul")
console.log(ul2);

const ul1 = document.querySelector(".box ul")
console.log(ul1);

const li44 = document.querySelector(".box ul li:last-child")
console.log(li44);

// querySelectorAll
const paras = document.querySelectorAll("p")
console.log(paras);
console.log(paras[1]);
console.log(paras.length);

// Duyet NodeList
for (let i = 0; i < paras.length; i++) {
    console.log(paras[i]);
}

Array.from(paras).map(ele => console.log(ele));

// Truy cập gián tiếp
console.log(para3.previousElementSibling);
console.log(para3.nextElementSibling);
console.log(para3.parentElement);

// Thay đổi css
heading.style.color = "red";
heading.style.backgroundColor = "black";

for (let i = 0; i < paras.length; i++) {
    paras[i].style.color = "white";
}

paras.forEach(ele => {
    ele.style.backgroundColor = "black";
})

Array.from(paras).map(ele => {
    ele.style.fontSize = "30px";
});

// Lấy ra nội dung
console.log(heading.innerHTML);
console.log(heading.innerText);
console.log(heading.textContent);

console.log(ul1.innerHTML);
console.log(ul1.innerText);
console.log(ul1.textContent);

// Thay đổi nội dung
heading.innerHTML = "Xin chào"
heading.innerHTML = "<span>Các bạn</span>"

heading.innerText = "Các bạn có khỏe không?"
heading.innerText = "<span>Rất yếu</span>"

// Tạo thẻ
const link = document.createElement("a");
link.innerText = "Google";
link.href = "https://google.com";

// document.body.prepend(link);
// document.body.appendChild(link);

const boxEl = document.querySelector(".box");

document.body.insertBefore(link, boxEl);

// Tạo thẻ li có nội dung "li new" nằm trước thẻ li "Thẻ li 3"

para2.insertAdjacentHTML("beforebegin", "<button>Login</button>")

const para1 = document.querySelector("p");
para1.insertAdjacentHTML("afterend", "<button>Logout</button>")

// Tạo thẻ
const li = document.createElement("li");
li.innerText = "Li mới";

ul1.insertAdjacentElement("afterbegin", li);

// Xóa
// document.body.removeChild(para2)
para2.parentElement.removeChild(para2);

// Thay thế
const h2 = document.createElement("h2");
h2.innerText = "Đây là thẻ h2";

// document.body.replaceChild(h2, heading)
heading.parentElement.replaceChild(h2, heading);

// Copy
const boxCopy1 = boxEl.cloneNode(true);
const boxCopy2 = boxEl.cloneNode(false);

console.log(boxCopy1);
console.log(boxCopy2);

h2.insertAdjacentElement("afterend", boxCopy1)
