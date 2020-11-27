<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <!--CSS-->
    <link rel="stylesheet" href="../view/css/style.css">
    <link rel="stylesheet" href="../view/css/employeeSection.css">

    <!--    External Font for Header    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">


    <title>Order Records Page</title>
</head>
<body>


<!--     Customer Records Page    -->
<div class="orderRecords">

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

            <li><a href="../employeeSection/employeeSection.html">Employee</a>

            <li><a href="../html-faq/faq.html">FAQs</a>

        </ul>
    </div>

    <div class="orderRecords-content">

        <h1>Order Records<br><br></h1>


        <table id="recordTable">
            <tr>
                <th>Order ID</th>
                <th>Customer ID</th>
                <th>Street Address</th>
                <th>City</th>
                <th>State</th>
                <th>Zip Code</th>
                <th>Shipping Cost</th>
                <th>Total Cost</th>
                <th>Date Ordered</th>
                <th>Date Delivered</th>
                <th></th>
            </tr>
            <tr>
                <td><label><input type="text" name="orderId" value=""/></label></td>
                <td><label><input type="text" name="order.customerId" value=""/></label></td>
                <td><label><input type="text" name="order.address" value=""/></label></td>
                <td><label><input type="text" name="order.city" value=""/></label></td>
                <td>
                    <jsp:include page="../templates/selectState.html"></jsp:include>
                </td>
                <td><label><input type="text" name="order.zip" value=""/></label></td>
                <td><label><input type="text" name="order.shippingCost" value=""/></label></td>
                <td><label><input type="text" name="order.totalCost" value=""/></label></td>
                <td><input type="date" id="orderDate" name="orderDate" value="" min="2020-01-01" max="2021-12-31"></td>
                <td><input type="date" id="deliveryDate" name="deliveryDate" value="" min="2020-01-01" max="2021-12-31"></td>
                <td>
                    <form action="../orderServlet" method="GET">
                        <input type="submit" name="Add New Order" value="Add New Order">
                    </form>
                </td>
            </tr>
            <c:forEach var="orderList" items="${orderList}">
                <tr>
                    <td>${orderList.id}</td>
                    <td>${orderList.customerId}</td>
                    <td>${orderList.address}</td>
                    <td>${orderList.city}</td>
                    <td>${orderList.state}</td>
                    <td>${orderList.zip}</td>
                    <td>${orderList.shippingCost}</td>
                    <td>${orderList.totalCost}</td>
                    <td>${orderList.orderDate}</td>
                    <td>${orderList.deliveryDate}</td>
                    <td>
                        <a href="edit?id=<c:out value='${orderList.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${orderList.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>

            <%--Sample layout--%>
            <tr>
                <td>{orderList.id}</td>
                <td>{orderList.customerId}</td>
                <td>{orderList.address}</td>
                <td>{orderList.city}</td>
                <td>{orderList.state}</td>
                <td>{orderList.zip}</td>
                <td>{orderList.shippingCost}</td>
                <td>{orderList.totalCost}</td>
                <td>{orderList.orderDate}</td>
                <td>{orderList.deliveryDate}</td>
                <td>
                    <a href="edit?id=<c:out value='${orderList.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${orderList.id}' />">Delete</a>
                </td>
            </tr>
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


