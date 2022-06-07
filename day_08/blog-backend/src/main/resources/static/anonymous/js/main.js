// Truy cập vào các thành phần
const signinEmailEl = document.getElementById("signin-email");
const signinPasswordEl = document.getElementById("signin-password");

const signupNameEl = document.getElementById("signup-name");
const signupEmailEl = document.getElementById("signup-email");
const signupPasswordEl = document.getElementById("signup-password");
const signupConfirmPasswordEl = document.getElementById("signup-confirm-password");

const btnSignin = document.getElementById("btn-signin");
const btnSignup = document.getElementById("btn-signup");

// Xử lý đăng nhập
btnSignin.addEventListener("click", async function() {
    // Lấy dữ liệu trong các ô input
    let email = signinEmailEl.value;
    let password = signinPasswordEl.value;
    
    if(!email || !password) {
        alert("Thông tin không được để trống");
        return;
    }
    
    // Gọi API login
    await axios.post(`/api/signin`, {
        email : email,
        password : password
    })

    // TODO : Xử lý sau khi login
})

// Xử lý đăng ký
btnSignup.addEventListener("click", async function() {
    // Lấy dữ liệu trong các ô input
    let name = signupNameEl.value;
    let email = signupEmailEl.value;
    let password = signupPasswordEl.value;
    let confirmPassword = signupConfirmPasswordEl.value;

    // Kiểm tra có để trống các trường hay không
    if(!name || !email || !password || !confirmPassword) {
        alert("Thông tin không được để trống");
        return;
    }

    // Kiểm tra password và confirm password có trùng nhau hay không
    if(password !== confirmPassword) {
        alert("Password và confirm password không giống nhau");
        return;
    }

    // Gửi API đăng ký tài khoản
    await axios.post(`/api/signin`, {
        name : name,
        email : email,
        password : password
    })

    // TODO : Xử lý sau khi đăng ký thành công
})