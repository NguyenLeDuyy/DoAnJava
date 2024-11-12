<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết sản phẩm</title>

    <link href="../resources/css/style1.css" rel="stylesheet">
</head>

<body>
    <form action="" method="">
        <div class="product-container-details">
            <!-- Nút thoát về trang chủ -->
            <div class="back-to-home">
                <a href="http://localhost/DoAnJava-demo/DoAnJava-demo/demoJava/home.php">Trở về trang chủ</a>
            </div>
            <div class="product-image-details">
                <!-- Hiển thị hình ảnh sản phẩm lớn -->
                <img id="main-image"
                    src="https://nhanvietluanvan.com/wp-content/uploads/2023/05/image24-1660292012-373-width2048height1696.jpg"
                    alt="Main Product Image">

                <!-- Các ảnh chi tiết nhỏ -->
                <div class="img-1">
                    <img src="https://i.pinimg.com/originals/e4/50/aa/e450aa2bf91b572a2902691d3d1ddb77.jpg" alt="Small Image 1"
                        onmouseover="previewImage(this)" onmouseout="resetMainImage()" onclick="changeMainImage(this)">
                    <img src="https://tse3.mm.bing.net/th?id=OIP.2iHVeDyqdDF1zlUXEseDMgHaFd&pid=Api&P=0&h=180" alt="Small Image 2"
                        onmouseover="previewImage(this)" onmouseout="resetMainImage()" onclick="changeMainImage(this)">
                    <img src="https://image-us.eva.vn/upload/3-2022/images/2022-08-12/image40-1660292012-583-width1629height2048.jpg" alt="Small Image 3"
                        onmouseover="previewImage(this)" onmouseout="resetMainImage()" onclick="changeMainImage(this)">
                </div>
            </div>

            <div class="product-info-details">
                <div class="product-details">
                    <span class="product-name-details">Tên sản phẩm: </span>
                    <span class="product-price-details">Giá sản phẩm: VNĐ</span>
                    <div class="product-description-details">Mô tả </div>
                </div>

                <div>
                    <p class="stock-status">Còn hàng</p>
                    <div class="product-quantity-actions flex">
                        <div class="quantity-controls">
                            <label for="qty" class="d-none">Số lượng</label>
                            <div class="quantity-buttons">
                                <button type="button" onclick="decreaseQuantity()">–</button>
                                <input type="number" id="qty" name="quantity" value="1" min="1">
                                <button type="button" onclick="increaseQuantity()">+</button>
                            </div>
                            <div class="magin-left-15">
                                <button type="submit">Thêm giỏ hàng</button>
                                <button type="submit">Đặt mua</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
<!-- JavaScript cho nút tăng giảm số lượng -->
<script src="../resources/js/ProductDetails.js"></script>
</html>