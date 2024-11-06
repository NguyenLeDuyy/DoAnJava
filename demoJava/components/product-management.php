<link rel="stylesheet" href="resources/css/product-management.css" />
<div class="product-management-container">
    <div class="search-container">
        <form id="searchForm">
            <input type="text" placeholder="Tìm kiếm..." name="search" id="searchInput">
            <button type="submit"><i class="fa fa-search"></i></button>
            <button type="button" id="addProductButton">Thêm sản phẩm</button>
        </form>
    
        <div class="product-list" id="productList">
          <!-- Products will be displayed here -->
        </div>
    </div>
    <div class="product-add">
        <form action="add-product.php" method="post" enctype="multipart/form-data">
            <label for="title">Tên Sản Phẩm:</label>
            <input type="text" id="title" name="title" required><br><br>
        
            <label for="price">Giá:</label>
            <input type="number" id="price" name="price" required><br><br>

            <label for="description">Mô Tả:</label>
            <textarea id="description" name="description" rows="4" cols="50"></textarea><br><br>

            <label for="category_id">Mã Danh Mục:</label>
            <input type="number" id="category_id" name="category_id" required><br><br>
        
            <label for="cover_image">Ảnh Bìa:</label>
            <input type="file" id="cover_image" name="cover_image"><br><br>

            <label for="image_urls">Ảnh Sản Phẩm Khác (có thể chọn nhiều ảnh):</label>
            <input type="file" id="image_urls" name="image_urls[]" multiple><br><br>

            <input type="submit" value="Thêm Sản Phẩm">
        </form>
    </div>

    <div class="product-edit" style="display: none;">
        <form id="editProductForm" action="edit-product.php" method="post" enctype="multipart/form-data">
            <input type="hidden" id="editProductId" name="id">
            <label for="editTitle">Tên Sản Phẩm:</label>
            <input type="text" id="editTitle" name="title" required><br><br>
    
            <label for="editPrice">Giá:</label>
            <input type="number" id="editPrice" name="price" required><br><br>

            <label for="editDescription">Mô Tả:</label>
            <textarea id="editDescription" name="description" rows="4" cols="50"></textarea><br><br>

            <label for="editCategoryId">Mã Danh Mục:</label>
            <input type="number" id="editCategoryId" name="category_id" required><br><br>
    
            <label for="editCoverImage">Ảnh Bìa:</label>
            <input type="file" id="editCoverImage" name="cover_image"><br><br>

            <label for="editImageUrls">Ảnh Sản Phẩm Khác (có thể chọn nhiều ảnh):</label>
            <input type="file" id="editImageUrls" name="image_urls[]" multiple><br><br>

            <input type="submit" value="Cập Nhật Sản Phẩm">
        </form>
    </div>

</div>
<script>
        /*list tạm do không có data */
        const products = [
            { id: 1, name: 'Product 1', image: 'resources/images/hoahong.jpg', price: '$10' },
            { id: 2, name: 'Product 2', image: 'resources/images/hoahong.jpg', price: '$20' },
            { id: 3, name: 'Product 3', image: 'resources/images/hoahong.jpg', price: '$30' },
            { id: 4, name: 'Product 4', image: 'resources/images/hoahong.jpg', price: '$15' }
        ];
        /* ẩn hiện form thêm sp */ 
        document.getElementById('addProductButton').addEventListener('click', function() {
            document.querySelector('.product-management-container').classList.toggle('show-add-product');
        }); 
        /* tìm kiếm các thứ */
        document.getElementById('searchForm').addEventListener('submit', function(event) {
            event.preventDefault();
            const query = document.getElementById('searchInput').value.toLowerCase();
            const filteredProducts = products.filter(product => product.name.toLowerCase().includes(query));
            displayProducts(filteredProducts);
        });
        /* hiện sp được tìm */
        function displayProducts(products) {
            const productList = document.getElementById('productList');
            productList.innerHTML = '';
            products.forEach(product => {
                const productItem = document.createElement('div');
                productItem.className = 'product-item';
                productItem.innerHTML = `
                    <img src="${product.image}" alt="${product.name}">
                    <h3>${product.name}</h3>
                    <p>${product.price}</p>
                    <button class="edit-button" onclick="editProduct(${product.id})">Sửa</button>
                    <button class="delete-button" onclick="deleteProduct(${product.id})">Xóa</button>
                `;
                productList.appendChild(productItem);
            });
        }
        /*thêm thông tin cho bảng sửa các thứ*/
        function editProduct(productId) {
            const product = products.find(p => p.id === productId);
            if (product) {
                document.getElementById('editProductId').value = product.id;
                document.getElementById('editTitle').value = product.name;
                document.getElementById('editPrice').value = product.price.replace('$', '');
                document.getElementById('editDescription').value = product.description || '';
                document.getElementById('editCategoryId').value = product.category_id || '';

                document.querySelector('.product-add').style.display = 'none';
                document.querySelector('.product-edit').style.display = 'block';
            }
        }
        /*ẩn form các thứ*/
    document.getElementById('addProductButton').addEventListener('click', function() {
    document.querySelector('.product-add').style.display = 'block';
    document.querySelector('.product-edit').style.display = 'none';
});

    function deleteProduct(id) {
        alert('Xóa sản phẩm với ID: ' + id);
        // Thêm mã để xử lý xóa sản phẩm tại đây
    }
</script>
