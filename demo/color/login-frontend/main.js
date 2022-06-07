const usernameInputEl = document.querySelector("#username");
const passwordInputEl = document.querySelector("#password")
const btnLogin = document.querySelector("#btn-login");

const usernameEl = document.querySelector(".username span");
const emailEl = document.querySelector(".email span");
const avatarEl = document.querySelector(".avatar img");

btnLogin.addEventListener("click", async function () {
    try {
        let usernameValue = usernameInputEl.value;
        let passwordValue = passwordInputEl.value;

        let res = await axios.post("http://localhost:8080/login", {
            username: usernameValue,
            password: passwordValue
        })

        displayUserInfo(res.data.data)
    } catch (error) {
        console.log(error.response.data.message);
    }
})

function displayUserInfo(user) {
    usernameEl.innerText = user.username;
    emailEl.innerText = user.email;
    avatarEl.src = user.avatar;
}