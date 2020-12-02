<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!--CSS-->
    <link rel="stylesheet" href="../view/css/style.css">
    <link rel="stylesheet" href="../view/css/employeeSection.css">
    <!--    External Font for Header    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">

    <title>Sale Receipt</title>

</head>
<body>

<!--      Services Page      -->
<div class="saleReceipt">

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
    <div class="saleReceipt-content">
        <div class="saleReceipt-container">

            <div id="header">
                <h1>Sale Receipt</h1>
            </div>

            <img src="../view/images/orderEntryImage.jpg" alt="HDS logo">
            <br><br>

            <div id="customerInfo">
                Customer #:${param.customer_id}
                <br><br>
                ${param.lastName},${param.first}<br>
                ${param.street}<br>
                ${param.city}, ${param.state}<br>${param.zip}
                <br> <br>
                Order Date: ${param.date_ordered}
                <br><br>
            </div>
            <div>
                <table id="topTable">
                    <tr>
                        <th>PRODUCT ID</th>
                        <th>PRODUCT NAME</th>
                        <th>MODEL NUMBER</th>
                        <th>SERIAL NUMBER</th>
                        <th>DESCRIPTION</th>
                        <th>LIST PRICE</th>
                        <th>QUANTITY</th>
                        <th>DELIVERY COST</th>
                        <th>EXACT COST</th>
                    </tr>

                    <tr>
                        <c:forEach var="order" items="${order}">
                        <td>${order.productID}</td>
                        <td>${order.productName}</td>
                        <td>${order.modelNum}</td>
                        <td>${order.serialNum}</td>
                        <td>${order.description}</td>
                        <td>$${order.listPrice}</td>
                        <td>${order.quantity}</td>
                        <td>$${order.shipping_cost}</td>
                        <td>$${order.exactCost}</td>
                    </tr>
                    </c:forEach>
                </table>

                <table id="bottomTable">
                    <tr>
                        <td>TAX 6%</td>
                        <td>$ ${param.total * .06}  </td>
                    </tr>
                    <tr>
                        <td>
                            SHIPPING/DELIVERY (HDS Delivered)
                            ($50 minimum shipping charge for first piece; $25 for each
                            additional
                            item.
                            Extra large item have a $100 sur charge - includes Sub Zero
                            Refrigerators,
                            and any other item that requires 2 delivery personnel)
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>TOTAL</td>
                        <td>$${param.total * 1.06}</td>
                    </tr>
                </table>


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
