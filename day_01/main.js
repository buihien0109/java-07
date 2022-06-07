console.log("Xin chào");

// Khai báo biến
let name = "Bùi Hiên";
console.log(name);

name = 19;
console.log(name);

const email = "hien@techmaster.vn";
console.log(email);

// email = "a@gmail.com";
// console.log(email);

let firstName = "Nguyễn"
let lastName = "Văn A"
console.log(firstName + " " + lastName);

console.log(`${firstName} ${lastName}. Năm nay tôi ${2022 - 1995} tuổi`);

let message = `Xin chào các bạn, mình tên là "Bùi Hiên". Mình sinh năm 1997`;
console.log(message);

// Function
function sum(a, b) {
    return a + b;
}

let data = sum(4,5)
console.log(data);

// First class function
// 1 function có thể gán cho 1 biến => function expresstion

// Higher order function
// 1 function có thể truyền vào như là 1 tham số cho function khác
// 1 function có thể return về 1 function khác

// function expresstion
let sum1 = function(a, b) {
    return a + b;
}
console.log(sum1(5, 5));

// arrow function
let sum2 = (a, b) => {
    return  a + b;
};

console.log(sum2(6, 7));


// Function

function hello() {
    name1 = "Bùi Hiên";
    
}

let name1 = "abc"

hello(); // Bùi Hiên
console.log(name1) // Lỗi