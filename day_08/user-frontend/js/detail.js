const API_URL = "http://localhost:8080/api/v1";

// Truy cập
const addressEl = document.getElementById("address");
const nameEl = document.getElementById("fullname");
const emailEl = document.getElementById("email");
const phoneEl = document.getElementById("phone");
const passwordEl = document.getElementById("password");
const btnSave = document.getElementById("btn-save");
const btnBack = document.querySelector(".btn-back");

const avatarEl = document.getElementById("avatar");
const avatarPreviewEl = document.getElementById("avatar-preview");

const btnModalImage = document.getElementById("btn-modal-image");
const imageContainerEl = document.querySelector(".image-container");
const paginationContainerEl = document.querySelector(".pagination-container");
const btnChoseImage = document.getElementById("btn-chose-image");
const btnDeleteImage = document.getElementById("btn-delete-image");

// Modal
const modalImage = new bootstrap.Modal(document.getElementById('modal-image'), {
    keyboard: false
})

// Lưu lại danh sách ảnh của user trong page hiện tại;
let imagesOfUser = [];

// Lưu lại page hiện tại;
let currentPage = 1;

// Lưu lại tổng số page
let totalPage = 0;

// Xử lý nút quay lại
btnBack.addEventListener("click", function () {
    window.location.href = "/";
});

// Lấy id trên URL
const params = new URLSearchParams(window.location.search);
const id = params.get("id");

// Kiểm tra có id hay không?
const checkUserExist = () => {
    if(!id) {
        window.location.href = "/404.html";
    }
}

// Gọi API
const getUser = async (id) => {
    try {
        let res = await axios.get(`${API_URL}/users/${id}`);

        renderUser(res.data);
    } catch (error) {
        console.log(error);
    }
};

// Render user
const renderUser = (user) => {
    nameEl.value = user.name;
    emailEl.value = user.email;
    phoneEl.value = user.phone;
    addressEl.value = user.address;

    // Avatar
    if (!user.avatar) {
        avatarPreviewEl.src = "https://via.placeholder.com/200";
    } else {
        avatarPreviewEl.src = `http://localhost:8080${user.avatar}`;
    }
};

// Lấy danh sách tỉnh thành phố
const getDistrict = async () => {
    try {
        let res = await axios.get("https://provinces.open-api.vn/api/p/");

        renderDistrict(res.data);
    } catch (error) {
        console.log(error);
    }
};

// Hiển thị tỉnh thành phố
const renderDistrict = (arr) => {
    let html = "";
    for (let i = 0; i < arr.length; i++) {
        const d = arr[i];
        html += `<option value="${d.name}">${d.name}</option>`;
    }
    addressEl.innerHTML = html;
};

// Upload file API
const uploadFileAPI = (file) => {
    const formData = new FormData();
    formData.append("file", file);

    return axios.post(`${API_URL}/users/${id}/upload-file`, formData);
};

// Xử lý khi upload file
avatarEl.addEventListener("change", async function (event) {
    try {
        // Lấy file cần upload
        let file = event.target.files[0];

        // Gọi API để upload file
        let res = await uploadFileAPI(file);

        // Cập nhật lại link ảnh sau khi upload thành công
        avatarPreviewEl.src = `http://localhost:8080${res.data.filePath}`;

        // Cập nhật lại tổng số page
        totalPage = res.data.totalPage;

        // Cập nhật lại trên giao diện
        imagesOfUser.pop();
        imagesOfUser.unshift(res.data.filePath)
        renderImage(imagesOfUser);
        renderPagination(totalPage);
    } catch (error) {
        console.log(error);
    }
});

// Lấy danh sách file của user
const getImage = async () => {
    try {
        let res = await axios.get(`${API_URL}/users/${id}/files?page=${currentPage}`);
        
        // Lưu lại danh sách ảnh của user
        imagesOfUser = res.data.files;

        // Lưu lại tổng số page
        totalPage = res.data.totalPage;

        // Render ảnh của user
        renderImage(imagesOfUser);

        // Render pagination
        renderPagination(totalPage);
    } catch (error) {
        console.log(error);
    }
};

const renderImage = (arr) => {
    // Render image
    imageContainerEl.innerHTML = "";
    for (let i = 0; i < arr.length; i++) {
        const f = arr[i];
        imageContainerEl.innerHTML += `
            <div class="image-item" onclick="choseImage(this)">
                <img src="http://localhost:8080${f}" alt="${f}" data-src="${f}">
            </div>
        `
    }
}

const renderPagination = (totalPage) => {
    let pages = Array.from(Array(totalPage).keys())
    paginationContainerEl.innerHTML = `
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <button 
                    class="page-link" 
                    aria-label="Previous" 
                    onclick="prevPage()"
                    ${currentPage == 1 ? "disabled" : ""}
                >
                    <span aria-hidden="true">&laquo;</span>
                </button>
            </li>
            ${
                pages.map(page => {
                    return `
                        <li class="page-item ${page + 1 == currentPage ? "active" : ""}">
                            <button 
                                class="page-link" 
                                onclick="chosePage(${page + 1})"
                                ${page + 1 == currentPage ? "disabled" : ""}
                            >${page + 1}</button>
                        </li>`
                }).join("")
            }
            <li class="page-item">
                <button 
                    class="page-link" 
                    aria-label="Next" 
                    onclick="nextPage()"
                    ${currentPage == totalPage ? "disabled" : ""}
                >
                    <span aria-hidden="true">&raquo;</span>
                </button>
            </li>
        </ul>
    `
}

const chosePage = page => {
    currentPage = page;
    getImage(currentPage)
}

const nextPage = () => {
    currentPage++
    getImage(currentPage)
}

const prevPage = () => {
    currentPage--
    getImage(currentPage)
}

const choseImage = image => {
    // Lấy danh sách ảnh
    const imagesEl = document.querySelectorAll(".image-item");

    // Xóa hết class "border-primary", "selected" trên tất cả các ảnh
    Array.from(imagesEl).map(el => el.classList.remove("border-primary", "selected"))

    // Thêm class "border-primary", "selected" vào ảnh được chọn
    image.classList.add("border-primary", "selected")

    // Bỏ disabled nút "Chọn ảnh"
    btnChoseImage.disabled = false;

    // Bỏ disabled nút "Xóa ảnh"
    btnDeleteImage.disabled = false;
}

btnModalImage.addEventListener("click", function() {
    getImage(currentPage);
});

// API update avatar
const updateAvatarAPI = imageSrc => {
    return axios.put(`${API_URL}/users/${id}/update-avatar`, {
        avatar : imageSrc
    });
}

// Xử lý phần chọn ảnh để thay đổi avatar
btnChoseImage.addEventListener("click", async function() {
    try {
        // Lấy ra ảnh đang được chọn
        const imageSelected = document.querySelector(".selected img");

        // Lấy ra đường dẫn ảnh của ảnh đang chọn
        const srcOfImageSelected = imageSelected.dataset.src;

        // Gọi API set lại ảnh cho user
        await updateAvatarAPI(srcOfImageSelected)

        // Update lại ảnh cho avatar
        avatarPreviewEl.src = `http://localhost:8080${srcOfImageSelected}`

        // Đóng modal lại
        modalImage.hide();
    } catch (error) {
        console.log(error);
    }
})

// API delete image
const deleteImageAPI = imageName => {
    return axios.delete(`${API_URL}/users/${id}/files/${imageName}`);
}

// Xử lý xóa ảnh
btnDeleteImage.addEventListener("click", async function() {
    try {
        // Lấy ra ảnh đang được chọn
        const imageSelected = document.querySelector(".selected img");

        // Lấy ra đường dẫn ảnh của ảnh đang chọn
        const srcOfImageSelected = imageSelected.dataset.src;

        // Lấy ra tên ảnh
        const indexStart = srcOfImageSelected.lastIndexOf("/")
        const imageName = srcOfImageSelected.slice(indexStart + 1).trim();

        // Gọi API set lại ảnh cho user
        totalPage = await deleteImageAPI(imageName)

        // Xóa ảnh trong mảng ban đầu
        // imagesOfUser = imagesOfUser.filter(img => img != )
    } catch (error) {
        console.log(error);
    }
})

// Chạy lấy tỉnh thành phố trước, sau đó mới lấy thông tin user
const init = async () => {
    checkUserExist();

    await getDistrict();
    await getUser(id);
};

init();
