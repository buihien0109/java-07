// Truy cập vào các thành phần
const paginationContainerEl = document.querySelector(".pagination-container");

// Lấy thông tin current page trên url
const params = new URLSearchParams(window.location.search);
const currentPage = Number(params.get("page")) || 1;

const renderPagination = (totalPage) => {
    let pages = Array.from(Array(totalPage).keys())
    paginationContainerEl.innerHTML = `
        <ul class="pagination justify-content-center">
            <li class="page-item ${currentPage === 1 ? "disabled" : ""}">
                <a 
                    class="page-link" 
                    href="/blogs?page=${currentPage - 1}"
                >
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            ${
                pages.map(page => {
                    return `
                        <li class="page-item ${page + 1 === currentPage ? "active" : ""} ${(page + 1 === currentPage) ? "disabled" : ""}">
                            <a 
                                class="page-link" 
                                href="/blogs?page=${page + 1}"
                            >${page + 1}</a>
                        </li>`
                }).join("")
            }
            <li class="page-item ${currentPage === totalPage ? "disabled" : ""}">
                <a 
                    class="page-link" 
                    href="/blogs?page=${currentPage + 1}"
                >
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    `
}

renderPagination(totalPage)