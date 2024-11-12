// Hiệu ứng cho ảnh ở trang ProductDetails

// Hàm giảm số lượng sản phẩm
function decreaseQuantity() {
    var qtyInput = document.getElementById('qty');
    var currentValue = parseInt(qtyInput.value);
    if (currentValue > 1) {
        qtyInput.value = currentValue - 1;
    }
}

// Hàm tăng số lượng sản phẩm
function increaseQuantity() {
    var qtyInput = document.getElementById('qty');
    var currentValue = parseInt(qtyInput.value);
    if (!isNaN(currentValue)) { // Kiểm tra giá trị là số
        qtyInput.value = currentValue + 1;
    } else {
        qtyInput.value = 1; // Gán giá trị mặc định nếu không hợp lệ
    }
}

// Đặt biến để lưu trữ đường dẫn ảnh chính ban đầu
let originalMainImageSrc;

document.addEventListener('DOMContentLoaded', function () {
    // Thiết lập ảnh chính ban đầu sau khi tải trang
    originalMainImageSrc = document.getElementById("main-image").src;
});

// Hàm hiển thị ảnh nhỏ khi di chuột
function previewImage(smallImg) {
    document.getElementById("main-image").src = smallImg.src;
}

// Hàm cố định ảnh khi nhấn vào ảnh nhỏ
function changeMainImage(smallImg) {
    originalMainImageSrc = smallImg.src; // Cập nhật ảnh chính mới
    document.getElementById("main-image").src = originalMainImageSrc;
}

// Hàm khôi phục ảnh chính về ảnh ban đầu khi rời chuột khỏi ảnh nhỏ
function resetMainImage() {
    document.getElementById("main-image").src = originalMainImageSrc;
}
