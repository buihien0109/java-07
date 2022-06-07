// Bài 1: Viết function tìm số lớn nhất trong mảng
function findMax(arr) {
    let max = arr[0];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

function findMax_01(arr) {
    return Math.max(...arr);
}

function findMax_02(arr) {
    return arr.sort((a, b) => b - a)[0];
}

// Bài 2: Viết function tìm số nhỏ nhất trong mảng
function findMin(arr) {
    let min = arr[0];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < min) {
            min = arr[i];
        }
    }
    return min;
}

function findMin_01(arr) {
    return Math.min(...arr);
}

function findMin_02(arr) {
    return arr.sort((a, b) => a - b)[0];
}

// Bài 3: Viết function cho phép truyền vào 1 mảng các số, kết quả trả về là 1 mảng mới với các số là số dư tương ứng khi chia mảng cũ cho 2
// Ví dụ : [4,2,5,6,2,7] => [0,0,1,0,0,1]
function modulo2(arr) {
    let result = [];
    for (let i = 0; i < arr.length; i++) {
        result.push(arr[i] % 2);
    }
    return result;
}

function modulo2_01(arr) {
    return arr.map((ele) => ele % 2);
}

// Bài 4: Viết function truyền vào 1 chuỗi, hãy sao chép đó chuỗi lên 10 lần (Sử dụng array để làm)
// Ví dụ: repeatString(‘a’) => Kết quả trả về là ‘aaaaaaaaaa’
function repeatString(str) {
    let result = [];
    for (let i = 0; i < 10; i++) {
        result.push(str);
    }
    return result.join("");
}

function repeatString_01(str) {
    return Array(10).fill(str).join("");
}

// Bài 5: Viết function truyền vào 1 chuỗi, hãy sao chép đó chuỗi lên 10 lần, ngăn cách nhau bởi dấu gạch ngang (Sử dụng array để làm)

// Ví dụ: repeatString(‘a’) => Kết quả trả về là ‘a-a-a-a-a-a-a-a-a-a’
function repeatStringWithDash(str) {
    let result = [];
    for (let i = 0; i < 10; i++) {
        result.push(str);
    }
    return result.join("-");
}

function repeatStringWithDash_01(str) {
    return Array(10).fill(str).join("-");
}

// Bài 1: Viết function để kiểm tra 1 giá trị có nằm trong mảng hay không?
// checkElementExist([1,2,3,4,5], 5) => true
// checkElementExist([1,2,3,4,5], 6) => false
function checkElementExist(arr, number) {
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] == number) {
            return true;
        }
    }
    return false;
}

function checkElementExist_01(arr, number) {
    return arr.some((ele) => ele == number);
}

function checkElementExist_02(arr, number) {
    return arr.includes(number);
}

function checkElementExist_03(arr, number) {
    if (arr.indexOf(number) != -1) {
        return true;
    }
    return false;
}

function checkElementExist_04(arr, number) {
    let arrFilter = arr.filter((ele) => ele == number);
    let result = arrFilter.length == 0 ? false : true;
    return result;
}

// Bài 2: Viết function truyền vào 1 mảng các số, và 1 giá trị bất kỳ. Trả về mảng mới với các giá trị lớn hơn giá trị truyền vào
// getElementGreater([1,2,3,4,5], 3) => [4,5]
// getElementGreater([1,2,3,4,5], 5) => []
function getElementGreater(arr, number) {
    return arr.filter((ele) => ele > number);
}

function getElementGreater_01(arr, number) {
    let newArr = [];
    for (let i = 0; i < arr.length; i++) {
        if (number < arr[i]) {
            newArr.push(arr[i]);
        }
    }
    return newArr;
}

// Bài 3: Viết function để tạo mã màu HEX ngẫu nhiên.
// randomHexCode() => #728a98
// randomHexCode() => #a72938
function randomHexCode() {
    let characters = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, "a", "b", "c", "d", "e", "f"];
    let hexCode = "#";
    for (let i = 0; i < 6; i++) {
        let randomCharacter =
            characters[Math.floor(Math.random() * characters.length)];
        hexCode += randomCharacter;
    }
    return hexCode;
}

// Bài 4: Viết function để tạo mã màu RGB ngẫu nhiên.
// randomRgbCode() => rgb(213,43,133)
// randomRgbCode() => rgb(12,32,122)
function randomRgbCode() {
    let r = Math.floor(Math.random() * 256);
    let g = Math.floor(Math.random() * 256);
    let b = Math.floor(Math.random() * 256);
    return `rgb(${r},${g},${b})`;
}
