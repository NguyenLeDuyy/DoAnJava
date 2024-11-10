<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanh Toán</title>
    <link href="../resources/css/style1.css" rel="stylesheet">
   
</head>

<body>
    
    <div class="payment-container">
    <div class="back-to-home t-left">
        <a href="http://localhost/DoAnJava-demo/DoAnJava-demo/demoJava/home.php">Trở về trang chủ</a>
    </div>
        <h2>Thông Tin Thanh Toán</h2>
        <form action="" method="post" id="payment-form">
            <div class="customer-info">
                <h3>Thông tin người mua</h3>
                <label for="full-name">Họ và Tên:</label>
                <input type="text" id="full-name" name="full-name" placeholder="Nhập họ và tên" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="Nhập email" required>

                <label for="phone">Số điện thoại:</label>
                <input type="text" id="phone" name="phone" placeholder="Nhập số điện thoại" required>

                <label for="address">Địa chỉ giao hàng:</label>
                <input type="text" id="address" name="address" placeholder="Nhập địa chỉ giao hàng" required>
            </div>

            <div class="payment-info">
                <h3>Phương thức thanh toán</h3>
                <label for="payment-method">Chọn phương thức thanh toán:</label>
                <select id="payment-method" name="payment-method" required>
                    <option value="cash-on-delivery" selected>Thanh toán bằng tiền mặt</option>
                    <option value="credit-card">Chuyển khoản</option>
                </select>

                <div class="cash-on-delivery-info" id="cash-on-delivery-info">
                    <p>Vui lòng thanh toán bằng tiền mặt khi nhận hàng.</p>
                </div>

                <div class="bank-transfer-info" id="bank-transfer-info" style="display: none;">
                    <label for="bank-name">Tên ngân hàng </label>
                    <input type="text" id="bank-name" name="bank-name" placeholder="Nhập tên ngân hàng">

                    <label for="account-number">Số tài khoản</label>
                    <input type="text" id="account-number" name="account-number" placeholder="Nhập Số tài khoản">

                    <label for="account-name">Tên chủ tài khoản</label>
                    <input type="text" id="account-name" name="account-name" placeholder="Nhập Tên Chủ tài khoản">
                </div>
            </div>

            <div class="order-summary">
                <h3>Tóm tắt đơn hàng</h3>
                <p><strong>Tổng tiền:</strong> 500.000 VNĐ</p>
                <button type="submit">Xác Nhận Thanh Toán</button>
            </div>
        </form>
    </div>

</body>
<script src="../resources/js/Payment.js"></script>
</html>
