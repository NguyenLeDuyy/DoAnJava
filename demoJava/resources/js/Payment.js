
// Thiết lập phương thức mặc định là thanh toán bằng tiền mặt khi tải trang
window.addEventListener('DOMContentLoaded', function () {
    document.getElementById('payment-method').value = 'cash-on-delivery';
    document.getElementById('cash-on-delivery-info').style.display = 'block';
    document.getElementById('bank-transfer-info').style.display = 'none';
});

// Hiển thị hoặc ẩn thông tin thanh toán khi chọn phương thức thanh toán
document.getElementById('payment-method').addEventListener('change', function (event) {
    var paymentMethod = event.target.value;
    var bankTransferInfo = document.getElementById('bank-transfer-info');
    var cashOnDeliveryInfo = document.getElementById('cash-on-delivery-info');

    if (paymentMethod === 'credit-card') {
        bankTransferInfo.style.display = 'block';
        cashOnDeliveryInfo.style.display = 'none';
    } else {
        bankTransferInfo.style.display = 'none';
        cashOnDeliveryInfo.style.display = 'block';
    }
});

// Chuyển hướng sau khi xác nhận thanh toán và kiểm tra dữ liệu đã nhập
document.getElementById('payment-form').addEventListener('submit', function (event) {
    event.preventDefault(); // Ngừng gửi form ngay lập tức

    var fullName = document.getElementById('full-name').value;
    var email = document.getElementById('email').value;
    var phone = document.getElementById('phone').value;
    var address = document.getElementById('address').value;
    var paymentMethod = document.getElementById('payment-method').value;

    if (fullName && email && phone && address) {
        if (paymentMethod === 'credit-card') {
            window.location.href = "https://mbbank.vn/thanhtoan"; // Đường dẫn trang thanh toán chuyển khoản
        } else {
            window.location.href = "http://localhost/DoAnJava-demo/DoAnJava-demo/demoJava/components/Thankyou.php"; // Đường dẫn trang xác nhận đơn hàng
        }
    } else {
        alert("Vui lòng điền đầy đủ thông tin.");
    }
});