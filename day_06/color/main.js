// const btnRandomName = document.getElementById("btn-random-name");
// const btnRandomHex = document.getElementById("btn-random-hex");
// const btnRandomRgb = document.getElementById("btn-random-rgb");

// btnRandomName.addEventListener("click", async function() {
//     try {
//         // Gọi API
//         let res = await axios.get("http://localhost:8080/random-color?type=1")

//         // Thay đổi màu của body
//         document.body.style.backgroundColor = res.data;
//     } catch (error) {
//         alert(error.response.data.message);
//     }
// })

const btns = document.querySelectorAll("button");
const colorNameEl = document.getElementById("color-name");

btns.forEach(btn => {
    btn.addEventListener("click", async function () {
        try {
            // Đọc type của phần tử
            let type = btn.dataset.type;

            // Gọi API
            let res = await axios.get(`http://localhost:8080/random-color?type=${type}`)

            // Hiển thị tên color
            colorNameEl.innerText = res.data;

            // Thay đổi màu của body
            document.body.style.backgroundColor = res.data;
        } catch (error) {
            alert(error.response.data.message);
        }
    })
})