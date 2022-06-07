// Array

// let arr = []
// arr[0] = "Hello";
// arr[1] = true;
// arr[2] = 10;

// console.log(arr);

// let numbers = [1, 2, 3, 4, 5];

// // In ra phần tử của array
// for (let i = 0; i < numbers.length; i++) {
//     console.log(numbers[i]);
// }

// // In ra phần tử của array
// numbers.forEach(function (value, index) {
//     console.log(`${value} - ${index}`);
// });

// // In ra phần tử của array sử dụng arrow function
// numbers.forEach((value, index) => {
//     console.log(`${value} - ${index}`);
// })

// // Tính tổng
// let total = 0;
// for (let i = 0; i < numbers.length; i++) {
//     total += numbers[i]
// }
// console.log(total)

// let arr1 = [3, 2, 1, 10, 12];
// let arr2 = [3, 2, 1];
// let text = "1,2,3";

// console.log(arr1 == arr2); // false
// console.log(arr1 != arr2); // true
// console.log(arr1 == text); // true
// console.log(arr1.sort() == arr1); // [1,2,3] == [3,2,1] // true

// console.log(arr1.sort((a, b) => a - b));

// map
let numbers = [1, 2, 3, 4]

let newArr = [];
for (let i = 0; i < numbers.length; i++) {
    newArr[i] = numbers[i] * 2
}

let newArr2 = numbers.map(ele => ele * 2);

// filter = for + if
// let isOdd = value => value % 2 == 1
// let arrOdd = numbers.filter(isOdd)

let arrOdd = numbers.filter(ele => ele % 2 == 1)
console.log(arrOdd);

// find : for + if + break
// Giá trị đầu tiên tìm thấy
let firstOddNumber = numbers.find(ele => ele % 2 == 1)
console.log(firstOddNumber);

// findIndex
// Chỉ số của giá trị đầu tiên tìm thấy
let indexFirstOddNumber = numbers.findIndex(ele => ele % 2 == 1)
console.log(indexFirstOddNumber);

// some()
// Chỉ 1 phần tử t/m điều kiện => true
// Không có phần tử nào t/m => false
console.log(numbers.some(ele => ele > 5));
console.log(numbers.some(ele => ele >= 4));

// every()
// Chỉ 1 phần tử không t/m điều kiện => false
// Tất cả phần tử t/m => true
console.log(numbers.some(ele => ele > 1));
console.log(numbers.some(ele => ele > 0));

// Gọi function truyền vào 1 mảng
indexFirstOddNumber([1,2,3,4])