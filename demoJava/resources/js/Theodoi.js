// orderTracking.js

// Giả lập dữ liệu đơn hàng (có thể thay thế bằng API hoặc cơ sở dữ liệu)
const orders = {
    "123456": "Đơn hàng đang được xử lý.",
    "789012": "Đơn hàng đã được vận chuyển.",
    "345678": "Đơn hàng đã được giao.",
};

// Lắng nghe sự kiện khi người dùng nhấn "Kiểm tra"
document.getElementById('order-tracking-form').addEventListener('submit', function(event) {
    event.preventDefault(); // Ngừng form gửi đi

    const orderId = document.getElementById('order-id').value; // Lấy mã đơn hàng nhập vào
    const orderStatus = document.getElementById('order-status');
    const orderStatusText = document.getElementById('order-status-text');

    // Kiểm tra xem đơn hàng có tồn tại hay không
    if (orders[orderId]) {
        orderStatus.style.display = 'block'; // Hiển thị phần trạng thái đơn hàng
        orderStatusText.textContent = orders[orderId]; // Hiển thị trạng thái của đơn hàng
    } else {
        orderStatus.style.display = 'block';
        orderStatusText.textContent = "Mã đơn hàng không tồn tại hoặc không đúng.";
    }
});
