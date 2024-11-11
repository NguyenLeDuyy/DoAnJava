<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Theo Dõi Đơn Hàng</title>
    <link href="../resources/css/style1.css" rel="stylesheet">
</head>

<body>
    
    <div class="tracking-container">
        <!-- Nút thoát về trang chủ -->
        <div class="back-to-home t-left">
            <a href="http://localhost/DoAnJava-demo/DoAnJava-demo/demoJava/home.php">Trở về trang chủ</a>
        </div>
        <h2>Theo Dõi Đơn Hàng</h2>
        <form action="" method="post" id="order-tracking-form">
            <label for="order-id">Nhập Mã Đơn Hàng:</label>
            <input type="text" id="order-id" name="order-id" placeholder="Mã đơn hàng" required>
            <button type="submit">Kiểm Tra</button>
        </form>

        <!-- Phần hiển thị kết quả -->
        <div class="order-status" id="order-status" style="display: none;">
            <h3>Tình Trạng Đơn Hàng</h3>
            <p id="order-status-text"></p>
        </div>
    </div>

    <!-- Liên kết với file JavaScript -->
    <script src="../resources/js/Theodoi.js"></script>
</body>

</html>
