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

        <h1>Edit Order Page<br><br></h1>


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
                <%--Edit Order--%>
                    <form action="../orderServlet" method="GET">
                <c:forEach var="orderList" items="${orderList}">
                <td>${orderList.order_id}</td>
                <td>
                    <label>
                        <input type="text" name="update_customerId"
                                  value="${orderList.customer_id}"/>
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="update_address"
                                  value="${orderList.street}"/>
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="update_city"
                                  value="${orderList.city}"/>
                    </label>
                </td>
                <td>
                    <jsp:include page="../templates/selectState.html"></jsp:include>
                </td>
                <td>
                    <label>
                        <input type="text" name="update_zip" value="${orderList.zip}"/>
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="update_shippingCost"
                                  value="${orderList.shipping_cost}"/>
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="update_totalCost"
                                  value="${orderList.total_cost}"/>
                    </label>
                </td>
                <td><input type="date" id="orderDate" name="update_orderDate"
                           value="${orderList.date_ordered}"
                           min="2020-01-01" max="2021-12-31"></td>
                <td><input type="date" id="deliveryDate" name="update_deliveryDate"
                           value="${orderList.date_delivered}"
                           min="2020-01-01" max="2021-12-31"></td>
                <td>
                    <input type="hidden" name="orderId"
                           value="<c:out value='${orderList.order_id}' />"/>
                    <input type="hidden" name="addressId"
                           value="<c:out value='${orderList.address_id}' />"/>
                        <input type="submit" name="Update Order" value="Update Order">
                    </form>
                </td>
            </tr>

            <tr>
                <td>${orderList.order_id}</td>
                <td>${orderList.customer_id}</td>
                <td>${orderList.street}</td>
                <td>${orderList.city}</td>
                <td>${orderList.state}</td>
                <td>${orderList.zip}</td>
                <td>${orderList.shipping_cost}</td>
                <td>${orderList.total_cost}</td>
                <td>${orderList.date_ordered}</td>
                <td>${orderList.date_delivered}</td>
                <td>
                    <form action="../orderServlet" method="GET">
                        <input type="hidden" name="customerId"
                               value="<c:out value='${orderList.order_id}' />"/>
                        <input type="hidden" name="addressId"
                               value="<c:out value='${orderList.address_id}' />"/>
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


