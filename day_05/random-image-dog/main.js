const btn = document.getElementById("btn-random");
const imageEl = document.querySelector(".image img");

btn.addEventListener("click", async function() {
    try {
        // B1 : Gọi API
        // Cách 1 : Sử dụng fetch API mặc định
        // Cách 2 : Sử dụng axios
        let res = await axios.get("https://dog.ceo/api/breeds/image/random")

        // B2 : Lấy kết quả từ API để gán link cho image
        imageEl.src = res.data.message
        
    } catch (error) {
        console.log(error.response.data.message);
    }

})