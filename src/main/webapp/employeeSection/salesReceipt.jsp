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

            <li><a href="../employeeSection/employeeSection.html">Employee</a>

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

            <div>
                <form action="customerServlet" method="GET">
                    Customer #:<label><input type="text" name="cusID" value=""></label>
                    <input type="submit" Name="Get Customer" value="Get Customer"><br><br>
                    Name:${cus.firstName}${cus.lastName}(cus.firstName)+(cus.lastName)<br>
                    Address:${cus.address}(cus.address)<br>
                    City: ${cus.city}(cus.city) State: ${cus.state}(cus.state)
                    Zip:${cus.zip}(cus.zip)
                </form>
                <br>
                <label for="saleDate">Date:</label>

                <input type="date" id="saleDate" name="saleDate"
                       value=""
                       min="2020-01-01" max="2021-12-31">
                <br><br>
            </div>
            <div>
                <table id="topTable">
                    <tr>
                        <th>ITEM</th>
                        <th>DESCRIPTION</th>
                        <th>QUANTITY</th>
                        <th>COST</th>
                        <th>EXACT COST</th>
                        <th>ADD/REMOVE</th>
                    </tr>

                    <tr>
                        <%--item column--%>
                        <td> product.id
                            <form action="customerServlet" method="GET">
                                <label> <input type="text" name="product.id"
                                               value=""></label>
                                <input type="submit" Name="Get Product"
                                       value="Get Product">
                            </form>
                        </td>
                        <%--<c:forEach var="product" items="${listProduct}">--%>
                        <td>${product.description}product.description</td>
                        <td>
                            <label>
                                <input id="quantityInput" type="number" min="0">
                            </label>
                        </td>
                        <td>${product.cost}product.cost</td>
                        <td id="display">
                            JS code to receive quantity amount and (*) product.cost
                        </td>
                        <td>
                            <button onclick="myCreateFunction()">Add</button>
                        </td>

                    </tr>
                </table>

                <table id="bottomTable">
                    <tr>
                        <td>TAX 6%</td>
                        <td>int tax = totalExactCost * .06</td>
                    </tr>
                    <tr>
                        <td>
                            SHIPPING/DELIVERY (HDS Delivered)
                            ($50 minimum shipping charge for first piece; $25 for each
                            additional
                            item.
                            Extra large item have a $100 sur charge - includes Sub Zero
                            Refrigerators,
                            and any other item tht requires 2 delivery personal)
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>TOTAL</td>
                        <td>int total = tax + totalExactCoast</td>
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

<script>
    const valueFromElement = document.getElementById('quantityInput');
    const display = document.getElementById('display');
    valueFromElement.addEventListener('change', updateValue);

    function updateValue(e) {
        display.textContent = e.target.value;
    }

    function myCreateFunction() {
        const table = document.getElementById("topTable");
        const row = table.insertRow(2);
        const cell1 = row.insertCell(0);
        const cell2 = row.insertCell(1);
        const cell3 = row.insertCell(2);
        const cell4 = row.insertCell(3);
        const cell5 = row.insertCell(4);
        const cell6 = row.insertCell(5);
        cell1.innerHTML = "product.id";
        cell2.innerHTML = "product.description";
        cell3.innerHTML = "";
        cell4.innerHTML = "product.cost";
        cell5.innerHTML = "";
        cell6.innerHTML = "";
    }

    function myDeleteFunction() {
        document.getElementById("topTable").deleteRow(0);
    }
</script>
</body>
</html>
