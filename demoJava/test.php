<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Homepage</title>
<link rel="stylesheet" href="resources/css/uikit.min.css" />


<script src="resources/js/uikit.min.js"></script>
 <script src="resources/js/uikit-icons.min.js"></script>

 <script src="https://cdn.tailwindcss.com">
  </script>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet"/>
</head>
<body>
    <?php require_once "components/admin/admin-header.html" ?>
    <main id="homepage">
    <?php require_once "components/admin/order-management.html";?>
    </main>
    </body>
</html>