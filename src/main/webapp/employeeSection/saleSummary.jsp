<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <!--CSS-->
    <link rel="stylesheet" href="../view/css/style.css">
    <link rel="stylesheet" href="../view/css/employeeSection.css">

    <!--    External Font for Header    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">


    <title>Sales Summary Page</title>
</head>
<body>


<!--     Customer Records Page    -->
<div class="saleSummary">

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

    <div class="saleSummary-content">

        <h1>Sale Summary<br><br></h1>

        <div id="dateRange">
            Starting Date:<label><input type="date" id="startDate" name="startDate"
                                        value=""
                                        min="2015-01-01" max="2021-12-31"></label>
            Ending Date:<label><input type="date" id="endDate" name="endDate"
                                      value=""
                                      min="2015-01-01" max="2021-12-31"></label>
            <br>
            <br>
            <form action="../orderServlet" method="POST">
                <input type="submit" name="Narrow Orders" value="Narrow Orders">
            </form>
            <br>
            <br>
        </div>

        <table id="recordTable">
            <tr>
                <th>Order ID</th>
                <th>Total Cost</th>
            </tr>

            <c:forEach var="saleList" items="${saleList}">
                <tr>
                    <td>${saleList.order_id}</td>
                    <td>${saleList.total_cost}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <br>
        <table id="saleSummaryTotal">
            <tr>
                <th> Total:</th>
                <td>{JS code to sum(totalCost)}</td>
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



