<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!--CSS-->
    <link rel="stylesheet" href="../view/css/style.css">
    <link rel="stylesheet" href="../view/css/employeeSection.css">

    <!--    External Font for Header    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">

    <title>Monthly Statement</title>

</head>
<body>


<!--      Services Page      -->
<div class="monthlyStatement">

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
    <div class="monthlyStatement-content">
        <div class="monthlyStatement-container">
            <div id="header">
                <h1>Computer Generated Statement Form</h1>
            </div>

            <br><br>
            <div>
                <table>
                    <tr>
                        <td id="image"><img src="../view/images/orderEntryImage.jpg"
                                            alt="HDS logo"></td>
                        <td id="statement topAddress"> Home Design Solutions<br>
                            101 Sedalia Dr.<br>
                            Phoenix, AZ 85001<br>
                            Phone: 602-KITCHEN<br>
                            FAX: 602-555-1212<br>
                        </td>
                    </tr>
                </table>
            </div>
            <br>
            <br>
            <div id="customerInfo">
                Customer #:${param.customer_id}
                <br><br>
                Prepared for: ${param.lastName},${param.first}<br>
                Address: ${param.street}<br>
                ${param.city}, ${param.state}<br>${param.zip}
                <br>
                Email: ${param.email}
                <br><br>
            </div>

            <div id="statement table">
                <table>
                    <tr>
                        <th>Order ID</th>
                        <th>Ordered Date</th>
                        <th>Total Cost</th>
                        <th>Account Balance</th>
                    </tr>
                    <c:forEach var="orderList" items="${orderList}">
                        <tr>

                            <td>${orderList.order_id}</td>
                            <td>${orderList.date_ordered}</td>
                            <td>$${orderList.total_cost}</td>
                            <td>$${orderList.accountBalance}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="statement bottom">
                TOTAL AMOUNT DUE (SUM (TOTAL))
            </div>
            <br>
            <div id="statement finePrint">
                *Terms & Conditions
                This statement must be paid on or before the 15th of the current month.
                Any bills not paid by the 15th will incur a $100 late payment charge.
                Invoices must contain the purchase order number and include complete
                supporting information required by HDS in order to be considered valid.
                Should HDS specify such changes and apply different terms and conditions,
                those terms and conditions will override the purchase order terms and
                conditions will apply instead of these.

            </div>
        </div>
    </div>
</div>


<footer>
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
