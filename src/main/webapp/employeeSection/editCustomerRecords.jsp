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

        <h1>Edit Customer Records<br><br></h1>


        <table id="recordTable">
            <tr>
                <th>Customer ID</th>
                <th>Last Name</th>
                <th>First Name</th>
                <th>Middle Initial</th>
                <th>Street Address</th>
                <th>City</th>
                <th>State</th>
                <th>Zip Code</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th></th>
            </tr>
            <tr>
                <%--Edit Customer--%>
                <form action="../customerServlet" method="GET">
                    <c:forEach var="customerList" items="${customerList}">

                    <td>${customerList.customer_id}</td>

                    <td>
                        <label>
                            <input type="text" name="cus_last_name"
                                   value="${customerList.customer_last_name}"/>
                        </label>
                    </td>
                    <td>
                        <label>
                            <input type="text" name="cus_first_name"
                                   value="${customerList.customer_first_name}"/>
                        </label>
                    </td>
                    <td>
                        <label>
                            <input type="text" name="cus_mi"
                                   value="${customerList.customer_mi}"/>
                        </label>
                    </td>
                    <td>
                        <label>
                            <input type="text" name="address_street"
                                   value="${customerList.street}"/>
                        </label>
                    </td>
                    <td>
                        <label>
                            <input type="text" name="address_city"
                                   value="${customerList.city}"/>
                        </label>
                    </td>
                    <td>
                        <jsp:include page="../templates/selectState.html"></jsp:include>
                    </td>
                    <td>
                        <label>
                            <input type="text" name="address_zip"
                                   value="${customerList.zip}"/>
                        </label>
                    </td>
                    <td>
                        <label>
                            <input type="tel" name="cus_phone_num"
                                   value="${customerList.customer_phone_num}"/>
                        </label>
                    </td>
                    <td>
                        <label>
                            <input type="email" name="cus_email"
                                   value="${customerList.customer_email}"/>
                        </label>
                    </td>
                        <input type="hidden" name="customerId"
                               value="<c:out value='${customerList.customer_id}' />"/>
                        <input type="hidden" name="addressId"
                               value="<c:out value='${customerList.customer_address_id}' />"/>
                    <td>
                        <input type="submit" name="Update Customer"
                               value="Update Customer">
                    </td>
                </form>
            </tr>

            <tr>
                <td>${customerList.customer_id}</td>
                <td>${customerList.customer_last_name}</td>
                <td>${customerList.customer_first_name}</td>
                <td>${customerList.customer_mi}</td>
                <td>${customerList.street}</td>
                <td>${customerList.city}</td>
                <td>${customerList.state}</td>
                <td>${customerList.zip}</td>
                <td>${customerList.customer_phone_num}</td>
                <td>${customerList.customer_email}</td>
                <td>
                    <form action="../customerServlet" method="GET">
                        <input type="hidden" name="customerId"
                               value="<c:out value='${customerList.customer_id}' />"/>
                        <input type="hidden" name="addressId"
                               value="<c:out value='${customerList.customer_address_id}' />"/>
                        <input type="submit" name="Delete" value="Delete">
                    </form>

                </td>
            </tr>
            </c:forEach>
            <%--Sample layout--%>

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

