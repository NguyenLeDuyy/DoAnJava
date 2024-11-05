<link rel="stylesheet" href="resources/css/product-management.css" />
<div class="product-management-container">
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
    <div class="search-container">
        <form id="searchForm">
            <input type="text" placeholder="Tìm kiếm..." name="search" id="searchInput">
            <button type="submit"><i class="fa fa-search"></i></button>
        </form>
    
        <div class="product-list" id="productList">
          <!-- Products will be displayed here -->
        </div>
    </div>
</div>
<script>
        const products = [
            { id: 1, name: 'Product 1', image: 'https://via.placeholder.com/150', price: '$10' },
            { id: 2, name: 'Product 2', image: 'https://via.placeholder.com/150', price: '$20' },
            { id: 3, name: 'Product 3', image: 'https://via.placeholder.com/150', price: '$30' },
            { id: 4, name: 'Hoa Hồng', image: 'https://via.placeholder.com/150', price: '$15' } // Thêm sản phẩm hoa hồng
        ];

        document.getElementById('searchForm').addEventListener('submit', function(event) {
            event.preventDefault();
            const query = document.getElementById('searchInput').value.toLowerCase();
            const filteredProducts = products.filter(product => product.name.toLowerCase().includes(query));
            displayProducts(filteredProducts);
        });

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

        function editProduct(id) {
            alert('Sửa sản phẩm với ID: ' + id);
            // Thêm mã để xử lý sửa sản phẩm tại đây
        }

        function deleteProduct(id) {
            alert('Xóa sản phẩm với ID: ' + id);
            // Thêm mã để xử lý xóa sản phẩm tại đây
        }
    </script>