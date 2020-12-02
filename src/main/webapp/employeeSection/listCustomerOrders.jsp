<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <!--CSS-->
    <link rel="stylesheet" href="../view/css/style.css">
    <link rel="stylesheet" href="../view/css/employeeSection.css">

    <!--    External Font for Header    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">


    <title>Customer Records Page</title>
</head>
<body>


<!--     Customer Records Page    -->
<div class="customerRecords">

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

            <li><a href="../employeeSection/employeeSection.html">Employee Log in</a>

            <li><a href="../html-faq/faq.html">FAQs</a>

        </ul>
    </div>

    <div class="customerRecords-content">

        <h1>List of Customers with Orders<br><br></h1>


        <table id="recordTable">
            <tr>
                <th>Customer ID</th>
                <th>Last Name</th>
                <th>First Name</th>
                <th>Order Number</th>
                <th></th>
            </tr>

            <c:forEach var="orderList" items="${orderList}">
                <tr>
                    <td>${orderList.customer_id}</td>
                    <td>${orderList.lastName}</td>
                    <td>${orderList.firstName}</td>
                    <td>${orderList.order_id}</td>
                    <td>
                        <form action="../orderServlet" method="POST">
                            <input type="hidden" name="customer_id"
                                   value="<c:out value='${orderList.customer_id}' />"/>
                            <input type="hidden" name="lastName"
                                   value="<c:out value='${orderList.lastName}' />"/>
                            <input type="hidden" name="first"
                                   value="<c:out value='${orderList.firstName}' />"/>
                            <input type="hidden" name="street"
                                   value="<c:out value='${orderList.street}' />"/>
                            <input type="hidden" name="city"
                                   value="<c:out value='${orderList.city}' />"/>
                            <input type="hidden" name="state"
                                   value="<c:out value='${orderList.state}' />"/>
                            <input type="hidden" name="zip"
                                   value="<c:out value='${orderList.zip}' />"/>
                            <input type="hidden" name="date_ordered"
                                   value="<c:out value='${orderList.date_ordered}' />"/>
                            <input type="hidden" name="id"
                                   value="<c:out value='${orderList.order_id}' />"/>
                            <input type="hidden" name="total"
                                   value="<c:out value='${orderList.total_cost}' />"/>
                            <input type="submit" name="Get Order" value="Get Order">
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
<script>

</script>

</body>
</html>


