<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <!--CSS-->
    <link rel="stylesheet" href="../view/css/style.css">
    <link rel="stylesheet" href="../view/css/employeeSection.css">

    <!--    External Font for Header    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">

    <title>Home Design Solutions | Inventory Page</title>
</head>
<body>

<!--     Inventory Page    -->
<div class="inventory">

    <!--      Navbar    -->
    <div class="nav">
        <div><strong>Home Design Solutions (HDS)</strong></div>

        <!--      Hyperlinks   -->
        <ul>
            <li><a href="../html-home/index.html">Home</a></li>
            <li><a href="../html-home/about.html">About</a></li>
            <li><a href="../html-home/contact.html">Contact</a></li>
        </ul>
    </div>

    <!--     Vertical DropDown Menu         -->
    <div id="divMenu">
        <ul>
            <li><a href="../html-home/about.html">About</a></li>

            <li><a href="../html-services/services.html">Services</a></li>

            <li><a href="#">Products</a>
                <ul>
                    <li><a href="../html-appliances/appliances.html">Appliances</a></li>
                    <li><a href="../html-appliances/cabinets.html">Cabinets</a></li>
                    <li><a href="../html-appliances/lighting.html">Lighting</a></li>
                    <li><a href="../html-appliances/plumbing.html">Plumbing</a></li>
                    <li><a href="../html-appliances/ct_ft.html">Countertops &
                        FloorTile</a></li>
                </ul>
            </li>

            <li><a href="#">Locations</a>
                <ul>
                    <li><a href="../html-locations/phoenix.html">Phoenix, AZ</a></li>
                    <li><a href="../html-locations/scottsdale.html">Scottsdale, AZ</a>
                    </li>
                    <li><a href="../html-locations/tucson.html">Tucson, AZ</a></li>
                    <li><a href="../html-locations/lv.html">Las Vegas, NV</a></li>
                    <li><a href="../html-locations/al.html">Albuquerque, NM</a></li>
                </ul>
            </li>

            <!--    Gallery Images      -->
            <li><a href="../html-gallery/gallery.html">Our Work</a></li>

            <li><a href="../employeeSection/loginPage.html">Employee Log in</a>

            <li><a href="../html-faq/faq.html">FAQs</a>

        </ul>
    </div>

    <div class="inventory-content">

        <h1>Edit Inventory<br><br></h1>

        <table id="inventoryTable">
            <tr>
                <th>Product ID</th>
                <th>Brand</th>
                <th>Category</th>
                <th>Inventory Count</th>
                <th>Model Number</th>
                <th>Serial Number</th>
                <th>Description</th>
                <th>Cost</th>
                <th>Listed Price</th>
                <th>Delivery Cost</th>
                <th>Is Active</th>
                <th></th>
            </tr>
            <tr>
                <form action="../inventoryServlet" method="GET">
                    <c:forEach var="productList" items="${productList}">
                    <td>
                            ${productList.product_id}
                    </td>
                    <td>
                            <jsp:include page="../templates/selectProductBrand.jsp"></jsp:include>
                    <td>
                        <label><input type="text" name="product.category_name"
                                      value="${productList.categoryName}"/></label>
                    </td>
                    <td>
                        <label><input type="text" name="product.inventory_count"
                                      value="${productList.inventory_count}"/></label>
                    </td>
                    <td>
                        <label><input type="text" name="product.model_num"
                                      value="${productList.model_num}"/></label></td>
                    <td>
                        <label><input type="text" name="product.serial_num"
                                      value="${productList.serial_num}"/></label></td>
                    <td>
                        <label><input type="text" name="product.description"
                                      value="${productList.description}"/></label></td>
                    <td>
                        <label><input type="text" name="product.cost"
                                      value="${productList.cost}"/></label>
                    </td>
                    <td>
                        <label><input type="text" name="product.list_price"
                                      value="${productList.list_price}"/></label></td>
                    <td>
                        <label><input type="text" name="product.deliveryCost"
                                      value="${productList.deliveryCost}"/></label></td>
                    <td>
                        <jsp:include page="../templates/selectActive.html"></jsp:include>
                    </td>

                    <td>
                        <input type="submit" name="Update Product"
                               value="Update Product">
                    </td>
                </form>
            </tr>

            <tr>
                <td>${productList.product_id}</td>
                <td>${productList.brandName}</td>
                <td>${productList.categoryName}</td>
                <td>${productList.inventory_count}</td>
                <td>${productList.model_num}</td>
                <td>${productList.serial_num}</td>
                <td>${productList.description}</td>
                <td>${productList.cost}</td>
                <td>${productList.list_price}</td>
                <td>${productList.deliveryCost}</td>
                <td>${productList.is_active}</td>
                <td>
                    <form action="../inventoryServlet" method="GET">
                        <input type="hidden" name="id"
                               value="<c:out value='${productList.product_id}' />"/>
                        <input type="submit" name="Delete" value="Delete">
                    </form>
                </td>
            </tr>
            </c:forEach>

        </table>

    </div>
</div>


<footer>
    <p><br><br><br></p>
    <h3>CONTACT US:<br><br></h3>
    <p>
        <strong>Home Design Solutions</strong> <br/>
        <strong>101 Sedalia Dr.</strong> <br/>
        <strong>Phoenix, AZ 85001</strong> <br/>
        Phone: 602-KITCHEN <br/>
        Fax: 602-555-1212
    </p>
</footer>


</body>
</html>
