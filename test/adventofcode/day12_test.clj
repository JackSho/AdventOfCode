(ns adventofcode.day12-test
  (:require [clojure.test :refer :all]
            [adventofcode.day12 :refer :all]))

;;http://adventofcode.com/2017/day/12/input

(def input "0 <-> 454, 528, 621, 1023, 1199\n1 <-> 1335, 1563, 1627, 1679\n2 <-> 353, 689\n3 <-> 3, 1171\n4 <-> 1247\n5 <-> 758, 928, 1260\n6 <-> 1010\n7 <-> 570\n8 <-> 710, 1610\n9 <-> 9\n10 <-> 10, 1822\n11 <-> 473\n12 <-> 255, 1355, 1999\n13 <-> 13, 1026\n14 <-> 113\n15 <-> 1954\n16 <-> 679, 918\n17 <-> 1101, 1637\n18 <-> 574, 1037\n19 <-> 481\n20 <-> 22, 815, 963, 1031\n21 <-> 1427\n22 <-> 20, 316, 802\n23 <-> 1328, 1447, 1708\n24 <-> 446, 1677\n25 <-> 25, 217\n26 <-> 184, 1138\n27 <-> 142\n28 <-> 1340\n29 <-> 954, 1174\n30 <-> 1185\n31 <-> 112, 1111\n32 <-> 1851\n33 <-> 662\n34 <-> 848\n35 <-> 315, 1983\n36 <-> 239\n37 <-> 422, 871, 1903\n38 <-> 1450, 1497\n39 <-> 923, 1652\n40 <-> 201, 434\n41 <-> 1878\n42 <-> 192, 1233\n43 <-> 1457\n44 <-> 499, 961\n45 <-> 1056\n46 <-> 302\n47 <-> 100, 1921\n48 <-> 1532\n49 <-> 728, 1028, 1201, 1301\n50 <-> 1662\n51 <-> 1186, 1773\n52 <-> 228, 1168, 1873\n53 <-> 413, 1111\n54 <-> 956\n55 <-> 477\n56 <-> 98\n57 <-> 1849, 1960\n58 <-> 440\n59 <-> 1115, 1389\n60 <-> 358, 499, 1392, 1582\n61 <-> 1704\n62 <-> 425\n63 <-> 1562, 1593\n64 <-> 916\n65 <-> 1842, 1951\n66 <-> 1991\n67 <-> 1026\n68 <-> 711\n69 <-> 854\n70 <-> 114, 1591\n71 <-> 1423\n72 <-> 1403\n73 <-> 170\n74 <-> 508, 831\n75 <-> 231, 1070, 1384, 1615\n76 <-> 751\n77 <-> 1190, 1421\n78 <-> 78, 1593\n79 <-> 221, 742, 1165\n80 <-> 1517\n81 <-> 1154\n82 <-> 310, 1027, 1358\n83 <-> 83, 1554\n84 <-> 743, 1208\n85 <-> 504, 1723\n86 <-> 1630\n87 <-> 919\n88 <-> 794\n89 <-> 1334\n90 <-> 1997\n91 <-> 494\n92 <-> 1210\n93 <-> 1619\n94 <-> 324, 1183, 1876\n95 <-> 300\n96 <-> 127, 1849\n97 <-> 733\n98 <-> 56, 534\n99 <-> 1028\n100 <-> 47, 402\n101 <-> 1053\n102 <-> 201, 498, 1016\n103 <-> 103, 1412\n104 <-> 105\n105 <-> 104, 608, 681\n106 <-> 106, 1605\n107 <-> 468, 1798\n108 <-> 1810\n109 <-> 789, 1300\n110 <-> 348, 550\n111 <-> 111\n112 <-> 31\n113 <-> 14, 136\n114 <-> 70, 132, 183, 847\n115 <-> 1086, 1409\n116 <-> 1220\n117 <-> 1047, 1886\n118 <-> 729\n119 <-> 119\n120 <-> 198\n121 <-> 1020, 1547\n122 <-> 891, 1241\n123 <-> 842, 866\n124 <-> 124, 1676\n125 <-> 1959\n126 <-> 895\n127 <-> 96\n128 <-> 664, 1170\n129 <-> 392, 1222\n130 <-> 1483, 1744\n131 <-> 1696\n132 <-> 114\n133 <-> 192\n134 <-> 134\n135 <-> 1696\n136 <-> 113, 803, 1064\n137 <-> 1738\n138 <-> 1486\n139 <-> 1811\n140 <-> 663, 1355, 1832\n141 <-> 226, 803\n142 <-> 27, 417\n143 <-> 486, 1441\n144 <-> 768, 850\n145 <-> 180, 669, 1935\n146 <-> 1242\n147 <-> 345, 1782\n148 <-> 1295, 1710\n149 <-> 1349\n150 <-> 697\n151 <-> 834\n152 <-> 152, 365\n153 <-> 654, 720\n154 <-> 1396, 1538\n155 <-> 804, 1891\n156 <-> 653, 1679\n157 <-> 302, 1108\n158 <-> 415, 680, 1668\n159 <-> 979, 1116, 1449\n160 <-> 463, 1627, 1769\n161 <-> 161, 232, 446, 874\n162 <-> 162, 527\n163 <-> 1760\n164 <-> 259, 750\n165 <-> 211, 945, 1022, 1069, 1071\n166 <-> 293\n167 <-> 178, 522\n168 <-> 301, 408, 622\n169 <-> 466, 1485, 1848\n170 <-> 73, 1028, 1761\n171 <-> 525, 755, 1219\n172 <-> 313, 476, 1383\n173 <-> 1629\n174 <-> 1795, 1977\n175 <-> 553, 1001\n176 <-> 1330\n177 <-> 375, 1013\n178 <-> 167\n179 <-> 1091, 1295\n180 <-> 145, 979, 1151\n181 <-> 803, 1107\n182 <-> 805, 872, 1366, 1894\n183 <-> 114, 685, 1252, 1508\n184 <-> 26\n185 <-> 402\n186 <-> 1748\n187 <-> 744, 971\n188 <-> 504\n189 <-> 814\n190 <-> 948\n191 <-> 506, 714\n192 <-> 42, 133, 854, 1152, 1250\n193 <-> 193\n194 <-> 1960\n195 <-> 382, 1551\n196 <-> 1759\n197 <-> 197\n198 <-> 120, 1070\n199 <-> 659, 1161\n200 <-> 875, 1572, 1819\n201 <-> 40, 102, 898, 1307\n202 <-> 436\n203 <-> 418, 771\n204 <-> 1114, 1224\n205 <-> 1011, 1979\n206 <-> 206, 882\n207 <-> 238\n208 <-> 1681\n209 <-> 1406\n210 <-> 1376\n211 <-> 165, 1153, 1916\n212 <-> 677\n213 <-> 915\n214 <-> 1280\n215 <-> 533\n216 <-> 626, 731\n217 <-> 25, 325\n218 <-> 1338\n219 <-> 596, 779\n220 <-> 339\n221 <-> 79, 620\n222 <-> 775, 1144\n223 <-> 439\n224 <-> 1825\n225 <-> 225\n226 <-> 141, 311\n227 <-> 1335\n228 <-> 52, 1861\n229 <-> 578, 727, 1085\n230 <-> 1036\n231 <-> 75, 766, 1386\n232 <-> 161\n233 <-> 953\n234 <-> 891\n235 <-> 1067\n236 <-> 419\n237 <-> 237\n238 <-> 207, 1687\n239 <-> 36, 1357\n240 <-> 1602\n241 <-> 241, 511, 960\n242 <-> 888, 1498, 1556\n243 <-> 1243, 1418, 1717\n244 <-> 364, 753\n245 <-> 643, 807\n246 <-> 1653\n247 <-> 1446, 1902\n248 <-> 1164, 1743\n249 <-> 645, 669\n250 <-> 556\n251 <-> 390, 1973\n252 <-> 956\n253 <-> 1149, 1574\n254 <-> 560, 1454, 1826\n255 <-> 12, 1214\n256 <-> 314, 820, 1087\n257 <-> 700, 1540, 1986\n258 <-> 258\n259 <-> 164\n260 <-> 1274\n261 <-> 1385\n262 <-> 765\n263 <-> 1231, 1509\n264 <-> 586\n265 <-> 586, 748, 1186\n266 <-> 1046, 1418\n267 <-> 877, 1572\n268 <-> 1370, 1688, 1980\n269 <-> 782, 1610\n270 <-> 789, 1052, 1102\n271 <-> 1787\n272 <-> 1076\n273 <-> 303, 1549\n274 <-> 353\n275 <-> 360\n276 <-> 717\n277 <-> 1955\n278 <-> 876, 890, 1311, 1920\n279 <-> 279, 515\n280 <-> 292, 1067, 1345\n281 <-> 1525, 1728\n282 <-> 1211\n283 <-> 1053\n284 <-> 312, 1647\n285 <-> 1534\n286 <-> 1738\n287 <-> 517, 1402\n288 <-> 514\n289 <-> 462, 915, 1401\n290 <-> 700, 1428, 1834\n291 <-> 1115, 1473\n292 <-> 280, 1185\n293 <-> 166, 564\n294 <-> 320, 1906\n295 <-> 850, 1276\n296 <-> 1843\n297 <-> 544\n298 <-> 1208, 1399\n299 <-> 577\n300 <-> 95, 421, 794\n301 <-> 168, 933\n302 <-> 46, 157, 1844\n303 <-> 273\n304 <-> 496\n305 <-> 1493\n306 <-> 736, 1316, 1622\n307 <-> 1495\n308 <-> 1286, 1357\n309 <-> 309, 1764\n310 <-> 82\n311 <-> 226\n312 <-> 284, 514, 845, 1476\n313 <-> 172, 361, 1663\n314 <-> 256, 809\n315 <-> 35, 1043\n316 <-> 22\n317 <-> 1418, 1643\n318 <-> 404, 1032, 1452, 1534\n319 <-> 841\n320 <-> 294, 949\n321 <-> 699, 925, 1274, 1700\n322 <-> 458, 1124, 1549\n323 <-> 323\n324 <-> 94, 1425, 1655\n325 <-> 217\n326 <-> 843, 1994\n327 <-> 327, 1556, 1952\n328 <-> 405, 1081\n329 <-> 329, 388\n330 <-> 369, 1084, 1846\n331 <-> 1700\n332 <-> 1772, 1973\n333 <-> 695, 1639\n334 <-> 703, 932\n335 <-> 335\n336 <-> 668, 1005\n337 <-> 702, 743\n338 <-> 517\n339 <-> 220, 339, 716, 773, 1132, 1924\n340 <-> 362, 1841\n341 <-> 885, 1034, 1325\n342 <-> 360, 1446\n343 <-> 343\n344 <-> 1017\n345 <-> 147, 1458\n346 <-> 1089\n347 <-> 925, 1774\n348 <-> 110, 1282, 1884\n349 <-> 551\n350 <-> 1630\n351 <-> 714\n352 <-> 619, 1926\n353 <-> 2, 274, 1824\n354 <-> 1459, 1854\n355 <-> 355\n356 <-> 399, 1251, 1600\n357 <-> 466, 1818, 1825\n358 <-> 60, 358\n359 <-> 570\n360 <-> 275, 342, 1768\n361 <-> 313, 361, 1303\n362 <-> 340, 580, 747, 1433\n363 <-> 1678\n364 <-> 244, 494\n365 <-> 152\n366 <-> 874\n367 <-> 367, 735, 1139\n368 <-> 459\n369 <-> 330\n370 <-> 881\n371 <-> 1133, 1213, 1438\n372 <-> 1290, 1963\n373 <-> 846, 1829\n374 <-> 780, 996\n375 <-> 177, 1126, 1223\n376 <-> 474, 1467\n377 <-> 1485, 1544\n378 <-> 1105, 1815, 1895\n379 <-> 507, 1936\n380 <-> 529, 806, 1654\n381 <-> 1306, 1606\n382 <-> 195, 676, 736, 1268\n383 <-> 383, 624, 1379\n384 <-> 384, 856\n385 <-> 1463\n386 <-> 495, 629, 1578\n387 <-> 836, 1670\n388 <-> 329\n389 <-> 488, 1477, 1866\n390 <-> 251\n391 <-> 391\n392 <-> 129, 828, 1877\n393 <-> 1436\n394 <-> 1495\n395 <-> 776, 879\n396 <-> 793, 1298\n397 <-> 523, 1192, 1693, 1712\n398 <-> 398\n399 <-> 356, 399, 1499\n400 <-> 400, 1104\n401 <-> 1039\n402 <-> 100, 185, 1600\n403 <-> 706, 1550\n404 <-> 318, 1374, 1697\n405 <-> 328, 1511\n406 <-> 602, 905\n407 <-> 407, 1910\n408 <-> 168, 1120, 1584\n409 <-> 1945\n410 <-> 1763\n411 <-> 1915\n412 <-> 448, 1486\n413 <-> 53, 681\n414 <-> 414\n415 <-> 158\n416 <-> 848, 1051\n417 <-> 142, 1717\n418 <-> 203, 1226, 1537\n419 <-> 236, 1144\n420 <-> 1027, 1793\n421 <-> 300, 671, 705\n422 <-> 37\n423 <-> 1013, 1607\n424 <-> 424, 437, 1332\n425 <-> 62, 774\n426 <-> 426, 1359\n427 <-> 1373\n428 <-> 718\n429 <-> 429, 1940\n430 <-> 1410\n431 <-> 554, 1941\n432 <-> 1845\n433 <-> 718, 1630\n434 <-> 40, 1780\n435 <-> 650\n436 <-> 202, 1467, 1853\n437 <-> 424\n438 <-> 680, 1018, 1538\n439 <-> 223, 1042, 1397\n440 <-> 58, 1860\n441 <-> 1138\n442 <-> 640, 723, 1322\n443 <-> 492, 958, 1736\n444 <-> 444\n445 <-> 533, 1530\n446 <-> 24, 161, 1735, 1892, 1898\n447 <-> 1998\n448 <-> 412, 1266\n449 <-> 972, 1397\n450 <-> 732, 1147\n451 <-> 1339, 1435, 1729\n452 <-> 520\n453 <-> 1810\n454 <-> 0\n455 <-> 1677\n456 <-> 1915\n457 <-> 1024, 1790\n458 <-> 322\n459 <-> 368, 1181\n460 <-> 460\n461 <-> 1181\n462 <-> 289, 557, 1804\n463 <-> 160\n464 <-> 822, 1330\n465 <-> 658\n466 <-> 169, 357, 1248\n467 <-> 467, 1278\n468 <-> 107\n469 <-> 1480\n470 <-> 1503\n471 <-> 1376, 1717\n472 <-> 1835\n473 <-> 11, 597\n474 <-> 376, 687, 1478, 1730\n475 <-> 701, 866\n476 <-> 172\n477 <-> 55, 1985\n478 <-> 478\n479 <-> 843, 1333, 1555\n480 <-> 609, 712\n481 <-> 19, 591, 1141\n482 <-> 1698, 1883\n483 <-> 664\n484 <-> 1367, 1965\n485 <-> 534, 1276\n486 <-> 143, 1380, 1757\n487 <-> 487\n488 <-> 389\n489 <-> 572\n490 <-> 1053, 1465\n491 <-> 840, 1074\n492 <-> 443, 1728\n493 <-> 631\n494 <-> 91, 364\n495 <-> 386, 1273, 1726, 1838\n496 <-> 304, 772\n497 <-> 572\n498 <-> 102\n499 <-> 44, 60\n500 <-> 1078\n501 <-> 642\n502 <-> 561, 587, 686, 816, 1905\n503 <-> 956, 1614\n504 <-> 85, 188, 518, 790, 1891\n505 <-> 1444\n506 <-> 191\n507 <-> 379, 1892\n508 <-> 74, 1522\n509 <-> 1429, 1863\n510 <-> 510\n511 <-> 241, 1797\n512 <-> 1487\n513 <-> 1280, 1997\n514 <-> 288, 312, 1699\n515 <-> 279, 1532\n516 <-> 516, 1714\n517 <-> 287, 338, 1364\n518 <-> 504, 1852\n519 <-> 762\n520 <-> 452, 666, 1139\n521 <-> 862, 1492\n522 <-> 167, 616, 1644, 1956\n523 <-> 397, 568\n524 <-> 1038, 1896\n525 <-> 171, 1239, 1847\n526 <-> 1272, 1907\n527 <-> 162, 1966\n528 <-> 0, 1623\n529 <-> 380\n530 <-> 1479\n531 <-> 1529\n532 <-> 1085, 1939\n533 <-> 215, 445, 1422, 1597\n534 <-> 98, 485, 1337, 1960\n535 <-> 880\n536 <-> 1518\n537 <-> 1009, 1274\n538 <-> 1535, 1620\n539 <-> 1971\n540 <-> 540\n541 <-> 565\n542 <-> 1679\n543 <-> 1374\n544 <-> 297, 740\n545 <-> 1461\n546 <-> 546\n547 <-> 547, 1019\n548 <-> 1436\n549 <-> 1589, 1980\n550 <-> 110, 573\n551 <-> 349, 1555\n552 <-> 1725\n553 <-> 175, 553, 1410\n554 <-> 431, 776, 897\n555 <-> 1859\n556 <-> 250, 875\n557 <-> 462, 998, 1124\n558 <-> 1409\n559 <-> 912\n560 <-> 254\n561 <-> 502, 561\n562 <-> 1679\n563 <-> 1299\n564 <-> 293, 1259\n565 <-> 541, 1312, 1441, 1913\n566 <-> 1907\n567 <-> 1159\n568 <-> 523\n569 <-> 1873\n570 <-> 7, 359, 869\n571 <-> 1752, 1779\n572 <-> 489, 497, 811, 953\n573 <-> 550\n574 <-> 18, 1238\n575 <-> 1771\n576 <-> 1442, 1630\n577 <-> 299, 1453\n578 <-> 229, 1142, 1868\n579 <-> 1878, 1977\n580 <-> 362\n581 <-> 1811\n582 <-> 1675\n583 <-> 765, 1632\n584 <-> 983\n585 <-> 1201\n586 <-> 264, 265\n587 <-> 502, 1680, 1968\n588 <-> 616\n589 <-> 1354, 1575\n590 <-> 1106\n591 <-> 481, 1179\n592 <-> 1946\n593 <-> 733, 1670\n594 <-> 1129, 1271\n595 <-> 1280\n596 <-> 219, 1168\n597 <-> 473, 876\n598 <-> 1089\n599 <-> 1334\n600 <-> 1308\n601 <-> 604, 870, 1817, 1946\n602 <-> 406, 1369\n603 <-> 1442\n604 <-> 601\n605 <-> 862\n606 <-> 1355\n607 <-> 1157\n608 <-> 105\n609 <-> 480, 756\n610 <-> 1040, 1657\n611 <-> 987, 1259\n612 <-> 612, 1672\n613 <-> 613, 1631\n614 <-> 1602, 1795\n615 <-> 646, 894\n616 <-> 522, 588, 850\n617 <-> 617, 1254\n618 <-> 1352\n619 <-> 352, 1855\n620 <-> 221, 620\n621 <-> 0\n622 <-> 168, 1373\n623 <-> 700\n624 <-> 383\n625 <-> 1321, 1343\n626 <-> 216\n627 <-> 1034\n628 <-> 1271\n629 <-> 386, 1172, 1973\n630 <-> 1544, 1954\n631 <-> 493, 1334\n632 <-> 1375, 1491\n633 <-> 1456\n634 <-> 1982\n635 <-> 924, 1054, 1617\n636 <-> 825\n637 <-> 1653\n638 <-> 1098, 1321, 1404, 1790\n639 <-> 639\n640 <-> 442, 640, 1507\n641 <-> 1519\n642 <-> 501, 1401\n643 <-> 245\n644 <-> 714, 1348\n645 <-> 249, 1329\n646 <-> 615, 1733\n647 <-> 1912\n648 <-> 1598\n649 <-> 933\n650 <-> 435, 1895\n651 <-> 1537\n652 <-> 652, 1240, 1879\n653 <-> 156, 1920\n654 <-> 153, 1749\n655 <-> 1248\n656 <-> 700, 919, 1118, 1969\n657 <-> 657, 1851\n658 <-> 465, 1474\n659 <-> 199, 818, 920\n660 <-> 660\n661 <-> 745\n662 <-> 33, 1115, 1978\n663 <-> 140, 1726\n664 <-> 128, 483, 1780\n665 <-> 1520\n666 <-> 520\n667 <-> 806\n668 <-> 336, 934\n669 <-> 145, 249, 1846\n670 <-> 819, 1526, 1802\n671 <-> 421\n672 <-> 1870\n673 <-> 931, 1018, 1211\n674 <-> 1627\n675 <-> 675\n676 <-> 382, 819\n677 <-> 212, 1163\n678 <-> 733\n679 <-> 16, 1149, 1402, 1959\n680 <-> 158, 438, 886\n681 <-> 105, 413, 1385\n682 <-> 1309\n683 <-> 1539\n684 <-> 1034, 1520, 1801, 1927\n685 <-> 183\n686 <-> 502\n687 <-> 474\n688 <-> 786\n689 <-> 2, 1671\n690 <-> 1673, 1946\n691 <-> 1732\n692 <-> 1853\n693 <-> 1230\n694 <-> 694, 1823\n695 <-> 333\n696 <-> 1214\n697 <-> 150, 697\n698 <-> 1181\n699 <-> 321, 1292, 1480\n700 <-> 257, 290, 623, 656\n701 <-> 475, 1205\n702 <-> 337, 1597\n703 <-> 334\n704 <-> 912, 989, 1613\n705 <-> 421, 849, 1215, 1270\n706 <-> 403, 1648\n707 <-> 1396\n708 <-> 1081, 1687\n709 <-> 1237\n710 <-> 8, 826, 926, 1685\n711 <-> 68, 711\n712 <-> 480\n713 <-> 1438, 1461, 1824, 1996\n714 <-> 191, 351, 644\n715 <-> 1058, 1875\n716 <-> 339\n717 <-> 276, 983, 1582, 1888\n718 <-> 428, 433, 1227, 1239\n719 <-> 1339, 1341\n720 <-> 153, 1101, 1411\n721 <-> 754, 878, 1794\n722 <-> 1255, 1862\n723 <-> 442, 760, 896\n724 <-> 1033\n725 <-> 1115\n726 <-> 825, 1562\n727 <-> 229, 994\n728 <-> 49, 752, 947, 1589\n729 <-> 118, 759, 985, 1070, 1760\n730 <-> 1072\n731 <-> 216, 1755\n732 <-> 450, 1264\n733 <-> 97, 593, 678, 1259\n734 <-> 1099, 1531, 1811\n735 <-> 367, 1586\n736 <-> 306, 382, 1625\n737 <-> 1886\n738 <-> 1991\n739 <-> 1684, 1827\n740 <-> 544, 1539, 1694, 1737\n741 <-> 741\n742 <-> 79\n743 <-> 84, 337, 743\n744 <-> 187, 1992\n745 <-> 661, 1266, 1856\n746 <-> 1674\n747 <-> 362, 1383\n748 <-> 265, 1429\n749 <-> 1299\n750 <-> 164, 1216, 1336, 1469, 1734\n751 <-> 76, 1011\n752 <-> 728\n753 <-> 244, 803\n754 <-> 721, 1890\n755 <-> 171\n756 <-> 609, 1470, 1934\n757 <-> 1098, 1885\n758 <-> 5\n759 <-> 729, 1092, 1363\n760 <-> 723, 946\n761 <-> 1321, 1704\n762 <-> 519, 1317, 1776\n763 <-> 1693\n764 <-> 1093\n765 <-> 262, 583, 1250, 1545, 1642\n766 <-> 231\n767 <-> 835, 1395\n768 <-> 144\n769 <-> 984\n770 <-> 1232\n771 <-> 203\n772 <-> 496, 1437\n773 <-> 339\n774 <-> 425, 774, 1015\n775 <-> 222\n776 <-> 395, 554\n777 <-> 1278\n778 <-> 778, 991, 1062\n779 <-> 219, 1993\n780 <-> 374\n781 <-> 917, 1716, 1929, 1962\n782 <-> 269\n783 <-> 1381\n784 <-> 1075, 1790, 1965\n785 <-> 914, 1504\n786 <-> 688, 1319, 1440, 1771, 1981\n787 <-> 1161, 1750\n788 <-> 1279, 1632\n789 <-> 109, 270, 853, 865, 1806, 1840\n790 <-> 504\n791 <-> 791\n792 <-> 1041\n793 <-> 396, 1562, 1827\n794 <-> 88, 300, 817\n795 <-> 956\n796 <-> 1323, 1816\n797 <-> 921, 1331\n798 <-> 1621\n799 <-> 1871\n800 <-> 800\n801 <-> 1608, 1823\n802 <-> 22, 1326\n803 <-> 136, 141, 181, 753, 1082, 1374\n804 <-> 155, 1252, 1487\n805 <-> 182\n806 <-> 380, 667, 1623\n807 <-> 245, 844, 1564, 1567, 1724\n808 <-> 1193\n809 <-> 314, 1033, 1333\n810 <-> 1643\n811 <-> 572\n812 <-> 812, 1681, 1799\n813 <-> 1726\n814 <-> 189, 1861, 1912\n815 <-> 20, 939\n816 <-> 502\n817 <-> 794\n818 <-> 659, 1488\n819 <-> 670, 676\n820 <-> 256\n821 <-> 821\n822 <-> 464, 997, 1338\n823 <-> 823\n824 <-> 1016\n825 <-> 636, 726, 1988\n826 <-> 710, 1060, 1576\n827 <-> 1027, 1214\n828 <-> 392\n829 <-> 829\n830 <-> 1504, 1532\n831 <-> 74\n832 <-> 1730\n833 <-> 944, 1778, 1980\n834 <-> 151, 862\n835 <-> 767, 1755\n836 <-> 387, 1202, 1256\n837 <-> 871, 1233\n838 <-> 1028, 1246\n839 <-> 1158, 1468\n840 <-> 491\n841 <-> 319, 841\n842 <-> 123, 1759\n843 <-> 326, 479\n844 <-> 807\n845 <-> 312\n846 <-> 373, 1541, 1550\n847 <-> 114, 1533, 1614\n848 <-> 34, 416, 1116, 1391\n849 <-> 705, 870\n850 <-> 144, 295, 616, 1466, 1746\n851 <-> 1169, 1329\n852 <-> 1796, 1912\n853 <-> 789\n854 <-> 69, 192\n855 <-> 1089\n856 <-> 384, 1007\n857 <-> 1720\n858 <-> 1338\n859 <-> 1338, 1822\n860 <-> 1028, 1334\n861 <-> 1093, 1457, 1552\n862 <-> 521, 605, 834, 1309, 1903\n863 <-> 1232, 1960\n864 <-> 1823\n865 <-> 789, 1299\n866 <-> 123, 475, 1543\n867 <-> 945, 1573\n868 <-> 1569\n869 <-> 570, 1035\n870 <-> 601, 849\n871 <-> 37, 837, 1786\n872 <-> 182, 979\n873 <-> 1146, 1220\n874 <-> 161, 366, 1439\n875 <-> 200, 556\n876 <-> 278, 597, 1148\n877 <-> 267\n878 <-> 721, 1678, 1709\n879 <-> 395\n880 <-> 535, 1459\n881 <-> 370, 1481, 1643\n882 <-> 206, 1374, 1970\n883 <-> 1948\n884 <-> 884\n885 <-> 341, 1664\n886 <-> 680, 1217, 1515\n887 <-> 887\n888 <-> 242\n889 <-> 1972\n890 <-> 278\n891 <-> 122, 234, 962, 1762\n892 <-> 1845\n893 <-> 1692\n894 <-> 615, 1365\n895 <-> 126, 1948\n896 <-> 723, 965, 1002\n897 <-> 554, 897\n898 <-> 201, 1767\n899 <-> 1127, 1723, 1929\n900 <-> 1100, 1956\n901 <-> 1099, 1919\n902 <-> 1428\n903 <-> 1416\n904 <-> 1062\n905 <-> 406, 1991\n906 <-> 1253\n907 <-> 1616\n908 <-> 1744\n909 <-> 1261, 1824\n910 <-> 1773\n911 <-> 1340\n912 <-> 559, 704, 1289, 1369\n913 <-> 1420\n914 <-> 785\n915 <-> 213, 289\n916 <-> 64, 1481\n917 <-> 781\n918 <-> 16, 1304\n919 <-> 87, 656\n920 <-> 659, 950\n921 <-> 797, 1755\n922 <-> 1274, 1635\n923 <-> 39\n924 <-> 635\n925 <-> 321, 347\n926 <-> 710, 926\n927 <-> 1393, 1666\n928 <-> 5, 1981\n929 <-> 1570\n930 <-> 1864\n931 <-> 673, 1245\n932 <-> 334, 1203, 1642\n933 <-> 301, 649, 1164\n934 <-> 668, 1047, 1540, 1887\n935 <-> 1617\n936 <-> 1187\n937 <-> 937, 1353\n938 <-> 949, 1913\n939 <-> 815\n940 <-> 1649\n941 <-> 941\n942 <-> 1125\n943 <-> 943, 1404\n944 <-> 833, 1112\n945 <-> 165, 867, 964\n946 <-> 760\n947 <-> 728, 1596\n948 <-> 190\n949 <-> 320, 938, 1931\n950 <-> 920, 1992\n951 <-> 1590\n952 <-> 1422\n953 <-> 233, 572, 1127\n954 <-> 29, 1074\n955 <-> 1672\n956 <-> 54, 252, 503, 795\n957 <-> 995\n958 <-> 443, 1275\n959 <-> 966\n960 <-> 241, 1297, 1641, 1839\n961 <-> 44, 1050\n962 <-> 891\n963 <-> 20, 1144, 1875\n964 <-> 945, 1623\n965 <-> 896, 1768\n966 <-> 959, 1394\n967 <-> 1155\n968 <-> 1154, 1609\n969 <-> 1652, 1738\n970 <-> 970\n971 <-> 187\n972 <-> 449, 1135, 1707\n973 <-> 1029\n974 <-> 1267\n975 <-> 1587, 1928\n976 <-> 1248\n977 <-> 977, 1932\n978 <-> 1906\n979 <-> 159, 180, 872, 1218, 1560\n980 <-> 1086, 1830\n981 <-> 1426, 1689\n982 <-> 1671\n983 <-> 584, 717, 1408\n984 <-> 769, 1121\n985 <-> 729, 1344\n986 <-> 1486\n987 <-> 611\n988 <-> 988, 1800\n989 <-> 704\n990 <-> 1398\n991 <-> 778\n992 <-> 992\n993 <-> 1537\n994 <-> 727\n995 <-> 957, 1909\n996 <-> 374, 1848\n997 <-> 822, 1159\n998 <-> 557, 1691\n999 <-> 1393\n1000 <-> 1083\n1001 <-> 175, 1528\n1002 <-> 896\n1003 <-> 1003\n1004 <-> 1828, 1846, 1859\n1005 <-> 336\n1006 <-> 1871\n1007 <-> 856, 1362\n1008 <-> 1256, 1514, 1835\n1009 <-> 537, 1646\n1010 <-> 6, 1232\n1011 <-> 205, 751, 1976\n1012 <-> 1964\n1013 <-> 177, 423\n1014 <-> 1123\n1015 <-> 774, 1944\n1016 <-> 102, 824, 1557, 1912\n1017 <-> 344, 1017, 1113, 1649\n1018 <-> 438, 673, 1962\n1019 <-> 547\n1020 <-> 121, 1020\n1021 <-> 1909\n1022 <-> 165\n1023 <-> 0, 1601\n1024 <-> 457\n1025 <-> 1372, 1699\n1026 <-> 13, 67\n1027 <-> 82, 420, 827, 1383, 1686\n1028 <-> 49, 99, 170, 838, 860, 1961\n1029 <-> 973, 1029\n1030 <-> 1174\n1031 <-> 20, 1496, 1766, 1951\n1032 <-> 318, 1108\n1033 <-> 724, 809, 1917\n1034 <-> 341, 627, 684, 1269\n1035 <-> 869, 1061\n1036 <-> 230, 1181, 1522\n1037 <-> 18, 1470\n1038 <-> 524, 1038, 1445, 1561\n1039 <-> 401, 1972\n1040 <-> 610\n1041 <-> 792, 1041, 1787\n1042 <-> 439, 1853\n1043 <-> 315\n1044 <-> 1549, 1570, 1957\n1045 <-> 1719\n1046 <-> 266\n1047 <-> 117, 934\n1048 <-> 1468\n1049 <-> 1078, 1568, 1755\n1050 <-> 961\n1051 <-> 416\n1052 <-> 270\n1053 <-> 101, 283, 490, 1490\n1054 <-> 635, 1231\n1055 <-> 1061, 1260\n1056 <-> 45, 1056\n1057 <-> 1945\n1058 <-> 715\n1059 <-> 1933\n1060 <-> 826\n1061 <-> 1035, 1055\n1062 <-> 778, 904\n1063 <-> 1496, 1502, 1666\n1064 <-> 136, 1943\n1065 <-> 1979\n1066 <-> 1171\n1067 <-> 235, 280, 1657\n1068 <-> 1068\n1069 <-> 165\n1070 <-> 75, 198, 729\n1071 <-> 165\n1072 <-> 730, 1224, 1456\n1073 <-> 1073\n1074 <-> 491, 954, 1979\n1075 <-> 784, 1739\n1076 <-> 272, 1617\n1077 <-> 1636\n1078 <-> 500, 1049, 1285\n1079 <-> 1770\n1080 <-> 1103, 1472\n1081 <-> 328, 708, 1803\n1082 <-> 803\n1083 <-> 1000, 1803\n1084 <-> 330\n1085 <-> 229, 532\n1086 <-> 115, 980, 1086\n1087 <-> 256, 1351, 1933\n1088 <-> 1088, 1872\n1089 <-> 346, 598, 855, 1840\n1090 <-> 1193\n1091 <-> 179\n1092 <-> 759\n1093 <-> 764, 861, 1406\n1094 <-> 1094\n1095 <-> 1128, 1398\n1096 <-> 1477\n1097 <-> 1673\n1098 <-> 638, 757, 1364\n1099 <-> 734, 901\n1100 <-> 900\n1101 <-> 17, 720\n1102 <-> 270\n1103 <-> 1080, 1103, 1394\n1104 <-> 400, 1720\n1105 <-> 378, 1515\n1106 <-> 590, 1782\n1107 <-> 181\n1108 <-> 157, 1032\n1109 <-> 1799\n1110 <-> 1251\n1111 <-> 31, 53, 1541\n1112 <-> 944\n1113 <-> 1017\n1114 <-> 204\n1115 <-> 59, 291, 662, 725, 1616, 1617\n1116 <-> 159, 848\n1117 <-> 1176\n1118 <-> 656\n1119 <-> 1461\n1120 <-> 408\n1121 <-> 984, 1436, 1518\n1122 <-> 1573, 1774\n1123 <-> 1014, 1606, 1678\n1124 <-> 322, 557\n1125 <-> 942, 1378, 1760\n1126 <-> 375, 1516, 1914\n1127 <-> 899, 953\n1128 <-> 1095, 1907\n1129 <-> 594, 1676\n1130 <-> 1774\n1131 <-> 1131, 1516\n1132 <-> 339, 1421\n1133 <-> 371\n1134 <-> 1227, 1669\n1135 <-> 972\n1136 <-> 1136, 1163\n1137 <-> 1654\n1138 <-> 26, 441, 1361, 1593\n1139 <-> 367, 520, 1140\n1140 <-> 1139\n1141 <-> 481, 1141\n1142 <-> 578\n1143 <-> 1980\n1144 <-> 222, 419, 963\n1145 <-> 1145\n1146 <-> 873, 1273\n1147 <-> 450, 1686\n1148 <-> 876, 1690\n1149 <-> 253, 679\n1150 <-> 1276\n1151 <-> 180\n1152 <-> 192, 1284\n1153 <-> 211, 1529\n1154 <-> 81, 968\n1155 <-> 967, 1205, 1954\n1156 <-> 1637\n1157 <-> 607, 1452\n1158 <-> 839\n1159 <-> 567, 997\n1160 <-> 1160, 1541\n1161 <-> 199, 787\n1162 <-> 1880\n1163 <-> 677, 1136\n1164 <-> 248, 933, 1667\n1165 <-> 79, 1313\n1166 <-> 1636\n1167 <-> 1810\n1168 <-> 52, 596, 1277\n1169 <-> 851\n1170 <-> 128, 1650\n1171 <-> 3, 1066\n1172 <-> 629\n1173 <-> 1537\n1174 <-> 29, 1030, 1175\n1175 <-> 1174\n1176 <-> 1117, 1385\n1177 <-> 1875\n1178 <-> 1887\n1179 <-> 591, 1191\n1180 <-> 1569, 1743\n1181 <-> 459, 461, 698, 1036\n1182 <-> 1652\n1183 <-> 94, 1724, 1734, 1974\n1184 <-> 1184\n1185 <-> 30, 292, 1308, 1625\n1186 <-> 51, 265, 1186, 1963, 1972\n1187 <-> 936, 1187\n1188 <-> 1494\n1189 <-> 1360, 1876\n1190 <-> 77\n1191 <-> 1179\n1192 <-> 397\n1193 <-> 808, 1090, 1619\n1194 <-> 1194\n1195 <-> 1195\n1196 <-> 1957\n1197 <-> 1263\n1198 <-> 1198\n1199 <-> 0\n1200 <-> 1200\n1201 <-> 49, 585, 1201, 1557, 1890\n1202 <-> 836\n1203 <-> 932\n1204 <-> 1911\n1205 <-> 701, 1155, 1350\n1206 <-> 1228, 1318, 1665\n1207 <-> 1373, 1741\n1208 <-> 84, 298\n1209 <-> 1485\n1210 <-> 92, 1626, 1775\n1211 <-> 282, 673\n1212 <-> 1807\n1213 <-> 371\n1214 <-> 255, 696, 827\n1215 <-> 705, 1378\n1216 <-> 750, 1538\n1217 <-> 886\n1218 <-> 979, 1523\n1219 <-> 171\n1220 <-> 116, 873\n1221 <-> 1553, 1827\n1222 <-> 129\n1223 <-> 375\n1224 <-> 204, 1072, 1660, 1757\n1225 <-> 1661, 1683, 1812\n1226 <-> 418\n1227 <-> 718, 1134\n1228 <-> 1206, 1490\n1229 <-> 1237\n1230 <-> 693, 1274, 1826\n1231 <-> 263, 1054, 1424\n1232 <-> 770, 863, 1010\n1233 <-> 42, 837\n1234 <-> 1342\n1235 <-> 1235\n1236 <-> 1805, 1881\n1237 <-> 709, 1229, 1390, 1589, 1590\n1238 <-> 574\n1239 <-> 525, 718\n1240 <-> 652\n1241 <-> 122\n1242 <-> 146, 1473\n1243 <-> 243\n1244 <-> 1244\n1245 <-> 931, 1282\n1246 <-> 838\n1247 <-> 4, 1662, 1679\n1248 <-> 466, 655, 976\n1249 <-> 1588\n1250 <-> 192, 765\n1251 <-> 356, 1110\n1252 <-> 183, 804\n1253 <-> 906, 1842\n1254 <-> 617\n1255 <-> 722, 1255\n1256 <-> 836, 1008\n1257 <-> 1437\n1258 <-> 1587\n1259 <-> 564, 611, 733\n1260 <-> 5, 1055\n1261 <-> 909\n1262 <-> 1912\n1263 <-> 1197, 1513\n1264 <-> 732, 1453\n1265 <-> 1864\n1266 <-> 448, 745, 1266\n1267 <-> 974, 1267, 1637, 1807\n1268 <-> 382\n1269 <-> 1034\n1270 <-> 705\n1271 <-> 594, 628\n1272 <-> 526\n1273 <-> 495, 1146\n1274 <-> 260, 321, 537, 922, 1230\n1275 <-> 958\n1276 <-> 295, 485, 1150\n1277 <-> 1168\n1278 <-> 467, 777\n1279 <-> 788\n1280 <-> 214, 513, 595, 1377, 1971\n1281 <-> 1658, 1812\n1282 <-> 348, 1245, 1978\n1283 <-> 1669\n1284 <-> 1152\n1285 <-> 1078, 1867\n1286 <-> 308, 1352\n1287 <-> 1560\n1288 <-> 1674, 1749\n1289 <-> 912\n1290 <-> 372, 1689\n1291 <-> 1495\n1292 <-> 699\n1293 <-> 1381, 1432, 1565, 1669\n1294 <-> 1926\n1295 <-> 148, 179, 1788, 1901\n1296 <-> 1296\n1297 <-> 960\n1298 <-> 396\n1299 <-> 563, 749, 865, 1733, 1882\n1300 <-> 109, 1423\n1301 <-> 49\n1302 <-> 1664\n1303 <-> 361\n1304 <-> 918, 1848\n1305 <-> 1376, 1659\n1306 <-> 381, 1482, 1638\n1307 <-> 201\n1308 <-> 600, 1185\n1309 <-> 682, 862\n1310 <-> 1310, 1857\n1311 <-> 278\n1312 <-> 565\n1313 <-> 1165\n1314 <-> 1357, 1816\n1315 <-> 1315\n1316 <-> 306, 1417\n1317 <-> 762, 1730\n1318 <-> 1206\n1319 <-> 786, 1489\n1320 <-> 1723\n1321 <-> 625, 638, 761\n1322 <-> 442\n1323 <-> 796, 1594, 1953\n1324 <-> 1755\n1325 <-> 341\n1326 <-> 802, 1864\n1327 <-> 1327\n1328 <-> 23, 1513\n1329 <-> 645, 851, 1682\n1330 <-> 176, 464\n1331 <-> 797, 1913\n1332 <-> 424\n1333 <-> 479, 809\n1334 <-> 89, 599, 631, 860, 1493\n1335 <-> 1, 227\n1336 <-> 750\n1337 <-> 534\n1338 <-> 218, 822, 858, 859\n1339 <-> 451, 719\n1340 <-> 28, 911, 1958\n1341 <-> 719\n1342 <-> 1234, 1417\n1343 <-> 625\n1344 <-> 985\n1345 <-> 280\n1346 <-> 1758\n1347 <-> 1347\n1348 <-> 644, 1907, 1927\n1349 <-> 149, 1882\n1350 <-> 1205, 1755\n1351 <-> 1087\n1352 <-> 618, 1286, 1837\n1353 <-> 937\n1354 <-> 589, 1909\n1355 <-> 12, 140, 606, 1646\n1356 <-> 1590\n1357 <-> 239, 308, 1314, 1990\n1358 <-> 82\n1359 <-> 426\n1360 <-> 1189\n1361 <-> 1138\n1362 <-> 1007\n1363 <-> 759\n1364 <-> 517, 1098\n1365 <-> 894\n1366 <-> 182, 1366\n1367 <-> 484\n1368 <-> 1765, 1963\n1369 <-> 602, 912\n1370 <-> 268\n1371 <-> 1877\n1372 <-> 1025\n1373 <-> 427, 622, 1207\n1374 <-> 404, 543, 803, 882\n1375 <-> 632, 1414\n1376 <-> 210, 471, 1305\n1377 <-> 1280\n1378 <-> 1125, 1215\n1379 <-> 383\n1380 <-> 486\n1381 <-> 783, 1293\n1382 <-> 1382\n1383 <-> 172, 747, 1027\n1384 <-> 75\n1385 <-> 261, 681, 1176, 1651\n1386 <-> 231\n1387 <-> 1387\n1388 <-> 1565\n1389 <-> 59\n1390 <-> 1237\n1391 <-> 848\n1392 <-> 60\n1393 <-> 927, 999\n1394 <-> 966, 1103\n1395 <-> 767\n1396 <-> 154, 707\n1397 <-> 439, 449, 1479, 1782\n1398 <-> 990, 1095, 1945\n1399 <-> 298\n1400 <-> 1907\n1401 <-> 289, 642\n1402 <-> 287, 679\n1403 <-> 72, 1624\n1404 <-> 638, 943\n1405 <-> 1572\n1406 <-> 209, 1093, 1707\n1407 <-> 1496, 1618\n1408 <-> 983\n1409 <-> 115, 558, 1805\n1410 <-> 430, 553\n1411 <-> 720\n1412 <-> 103\n1413 <-> 1733\n1414 <-> 1375, 1796\n1415 <-> 1601\n1416 <-> 903, 1718, 1971\n1417 <-> 1316, 1342, 1626\n1418 <-> 243, 266, 317, 1418, 1468, 1505\n1419 <-> 1419\n1420 <-> 913, 1836\n1421 <-> 77, 1132, 1502\n1422 <-> 533, 952\n1423 <-> 71, 1300, 1947\n1424 <-> 1231\n1425 <-> 324\n1426 <-> 981\n1427 <-> 21, 1575, 1696, 1798\n1428 <-> 290, 902, 1581\n1429 <-> 509, 748\n1430 <-> 1430\n1431 <-> 1967\n1432 <-> 1293\n1433 <-> 362, 1922\n1434 <-> 1486\n1435 <-> 451, 1779\n1436 <-> 393, 548, 1121, 1514\n1437 <-> 772, 1257, 1462, 1493\n1438 <-> 371, 713, 1557\n1439 <-> 874\n1440 <-> 786\n1441 <-> 143, 565, 1629\n1442 <-> 576, 603\n1443 <-> 1445\n1444 <-> 505, 1444, 1703\n1445 <-> 1038, 1443\n1446 <-> 247, 342\n1447 <-> 23\n1448 <-> 1935\n1449 <-> 159\n1450 <-> 38, 1450\n1451 <-> 1528, 1817\n1452 <-> 318, 1157, 1633\n1453 <-> 577, 1264\n1454 <-> 254\n1455 <-> 1487\n1456 <-> 633, 1072\n1457 <-> 43, 861\n1458 <-> 345, 1858\n1459 <-> 354, 880\n1460 <-> 1718\n1461 <-> 545, 713, 1119\n1462 <-> 1437\n1463 <-> 385, 1886, 1995\n1464 <-> 1862\n1465 <-> 490\n1466 <-> 850\n1467 <-> 376, 436, 1991\n1468 <-> 839, 1048, 1418, 1558, 1792\n1469 <-> 750\n1470 <-> 756, 1037\n1471 <-> 1878\n1472 <-> 1080, 1571\n1473 <-> 291, 1242\n1474 <-> 658, 1482\n1475 <-> 1930\n1476 <-> 312\n1477 <-> 389, 1096\n1478 <-> 474, 1588\n1479 <-> 530, 1397\n1480 <-> 469, 699\n1481 <-> 881, 916\n1482 <-> 1306, 1474\n1483 <-> 130\n1484 <-> 1558, 1877\n1485 <-> 169, 377, 1209, 1647\n1486 <-> 138, 412, 986, 1434\n1487 <-> 512, 804, 1455\n1488 <-> 818\n1489 <-> 1319, 1489\n1490 <-> 1053, 1228, 1490\n1491 <-> 632\n1492 <-> 521, 1566\n1493 <-> 305, 1334, 1437, 1620, 1732\n1494 <-> 1188, 1600\n1495 <-> 307, 394, 1291, 1495\n1496 <-> 1031, 1063, 1407\n1497 <-> 38\n1498 <-> 242\n1499 <-> 399\n1500 <-> 1998\n1501 <-> 1557\n1502 <-> 1063, 1421\n1503 <-> 470, 1503\n1504 <-> 785, 830\n1505 <-> 1418\n1506 <-> 1723, 1958\n1507 <-> 640\n1508 <-> 183\n1509 <-> 263\n1510 <-> 1642\n1511 <-> 405\n1512 <-> 1697\n1513 <-> 1263, 1328\n1514 <-> 1008, 1436\n1515 <-> 886, 1105\n1516 <-> 1126, 1131\n1517 <-> 80, 1850\n1518 <-> 536, 1121\n1519 <-> 641, 1809\n1520 <-> 665, 684\n1521 <-> 1521\n1522 <-> 508, 1036, 1593\n1523 <-> 1218\n1524 <-> 1747\n1525 <-> 281, 1525\n1526 <-> 670\n1527 <-> 1527\n1528 <-> 1001, 1451\n1529 <-> 531, 1153\n1530 <-> 445\n1531 <-> 734\n1532 <-> 48, 515, 830\n1533 <-> 847, 1549\n1534 <-> 285, 318\n1535 <-> 538\n1536 <-> 1742\n1537 <-> 418, 651, 993, 1173, 1999\n1538 <-> 154, 438, 1216, 1693\n1539 <-> 683, 740, 1539, 1982\n1540 <-> 257, 934\n1541 <-> 846, 1111, 1160, 1758\n1542 <-> 1612\n1543 <-> 866\n1544 <-> 377, 630\n1545 <-> 765\n1546 <-> 1907\n1547 <-> 121, 1938\n1548 <-> 1548\n1549 <-> 273, 322, 1044, 1533\n1550 <-> 403, 846\n1551 <-> 195, 1915\n1552 <-> 861, 1865\n1553 <-> 1221\n1554 <-> 83\n1555 <-> 479, 551\n1556 <-> 242, 327\n1557 <-> 1016, 1201, 1438, 1501\n1558 <-> 1468, 1484\n1559 <-> 1618\n1560 <-> 979, 1287\n1561 <-> 1038\n1562 <-> 63, 726, 793\n1563 <-> 1, 1563, 1634\n1564 <-> 807\n1565 <-> 1293, 1388\n1566 <-> 1492\n1567 <-> 807, 1594\n1568 <-> 1049\n1569 <-> 868, 1180\n1570 <-> 929, 1044, 1833\n1571 <-> 1472\n1572 <-> 200, 267, 1405\n1573 <-> 867, 1122\n1574 <-> 253\n1575 <-> 589, 1427, 1622, 1705\n1576 <-> 826\n1577 <-> 1780\n1578 <-> 386\n1579 <-> 1579\n1580 <-> 1699\n1581 <-> 1428\n1582 <-> 60, 717\n1583 <-> 1583\n1584 <-> 408\n1585 <-> 1585\n1586 <-> 735\n1587 <-> 975, 1258, 1587, 1619\n1588 <-> 1249, 1478\n1589 <-> 549, 728, 1237\n1590 <-> 951, 1237, 1356\n1591 <-> 70, 1639\n1592 <-> 1592, 1992\n1593 <-> 63, 78, 1138, 1522\n1594 <-> 1323, 1567\n1595 <-> 1966\n1596 <-> 947\n1597 <-> 533, 702\n1598 <-> 648, 1615\n1599 <-> 1622, 1694\n1600 <-> 356, 402, 1494\n1601 <-> 1023, 1415\n1602 <-> 240, 614, 1813, 1925\n1603 <-> 1645\n1604 <-> 1969\n1605 <-> 106\n1606 <-> 381, 1123\n1607 <-> 423\n1608 <-> 801\n1609 <-> 968, 1684\n1610 <-> 8, 269\n1611 <-> 1840\n1612 <-> 1542, 1933\n1613 <-> 704, 1725\n1614 <-> 503, 847\n1615 <-> 75, 1598\n1616 <-> 907, 1115\n1617 <-> 635, 935, 1076, 1115\n1618 <-> 1407, 1559\n1619 <-> 93, 1193, 1587\n1620 <-> 538, 1493\n1621 <-> 798, 1672, 1911\n1622 <-> 306, 1575, 1599\n1623 <-> 528, 806, 964\n1624 <-> 1403, 1989\n1625 <-> 736, 1185\n1626 <-> 1210, 1417\n1627 <-> 1, 160, 674\n1628 <-> 1844\n1629 <-> 173, 1441, 1930\n1630 <-> 86, 350, 433, 576\n1631 <-> 613\n1632 <-> 583, 788\n1633 <-> 1452\n1634 <-> 1563\n1635 <-> 922\n1636 <-> 1077, 1166, 1636\n1637 <-> 17, 1156, 1267\n1638 <-> 1306\n1639 <-> 333, 1591\n1640 <-> 1640\n1641 <-> 960\n1642 <-> 765, 932, 1510\n1643 <-> 317, 810, 881\n1644 <-> 522\n1645 <-> 1603, 1719\n1646 <-> 1009, 1355\n1647 <-> 284, 1485\n1648 <-> 706, 1785\n1649 <-> 940, 1017\n1650 <-> 1170\n1651 <-> 1385\n1652 <-> 39, 969, 1182, 1652\n1653 <-> 246, 637, 1919\n1654 <-> 380, 1137, 1923\n1655 <-> 324\n1656 <-> 1986\n1657 <-> 610, 1067\n1658 <-> 1281\n1659 <-> 1305\n1660 <-> 1224, 1869\n1661 <-> 1225\n1662 <-> 50, 1247\n1663 <-> 313\n1664 <-> 885, 1302, 1870\n1665 <-> 1206\n1666 <-> 927, 1063, 1903\n1667 <-> 1164\n1668 <-> 158, 1989\n1669 <-> 1134, 1283, 1293, 1669\n1670 <-> 387, 593, 1884\n1671 <-> 689, 982\n1672 <-> 612, 955, 1621\n1673 <-> 690, 1097\n1674 <-> 746, 1288\n1675 <-> 582, 1675\n1676 <-> 124, 1129\n1677 <-> 24, 455, 1979\n1678 <-> 363, 878, 1123\n1679 <-> 1, 156, 542, 562, 1247\n1680 <-> 587\n1681 <-> 208, 812\n1682 <-> 1329\n1683 <-> 1225\n1684 <-> 739, 1609\n1685 <-> 710\n1686 <-> 1027, 1147, 1939\n1687 <-> 238, 708, 1740\n1688 <-> 268\n1689 <-> 981, 1290, 1814\n1690 <-> 1148\n1691 <-> 998\n1692 <-> 893, 1862\n1693 <-> 397, 763, 1538\n1694 <-> 740, 1599\n1695 <-> 1695\n1696 <-> 131, 135, 1427\n1697 <-> 404, 1512\n1698 <-> 482, 1930\n1699 <-> 514, 1025, 1580\n1700 <-> 321, 331, 1945\n1701 <-> 1749\n1702 <-> 1702\n1703 <-> 1444\n1704 <-> 61, 761\n1705 <-> 1575\n1706 <-> 1706\n1707 <-> 972, 1406\n1708 <-> 23, 1791\n1709 <-> 878\n1710 <-> 148\n1711 <-> 1848\n1712 <-> 397\n1713 <-> 1899\n1714 <-> 516, 1860\n1715 <-> 1715\n1716 <-> 781\n1717 <-> 243, 417, 471\n1718 <-> 1416, 1460, 1785\n1719 <-> 1045, 1645, 1719\n1720 <-> 857, 1104\n1721 <-> 1971\n1722 <-> 1742, 1998\n1723 <-> 85, 899, 1320, 1506\n1724 <-> 807, 1183\n1725 <-> 552, 1613\n1726 <-> 495, 663, 813\n1727 <-> 1727\n1728 <-> 281, 492\n1729 <-> 451\n1730 <-> 474, 832, 1317\n1731 <-> 1858\n1732 <-> 691, 1493\n1733 <-> 646, 1299, 1413, 1733\n1734 <-> 750, 1183\n1735 <-> 446\n1736 <-> 443\n1737 <-> 740\n1738 <-> 137, 286, 969\n1739 <-> 1075\n1740 <-> 1687, 1942\n1741 <-> 1207\n1742 <-> 1536, 1722, 1742\n1743 <-> 248, 1180, 1743\n1744 <-> 130, 908, 1744\n1745 <-> 1745\n1746 <-> 850\n1747 <-> 1524, 1747\n1748 <-> 186, 1748\n1749 <-> 654, 1288, 1701, 1871\n1750 <-> 787\n1751 <-> 1751\n1752 <-> 571\n1753 <-> 1753\n1754 <-> 1754\n1755 <-> 731, 835, 921, 1049, 1324, 1350\n1756 <-> 1935\n1757 <-> 486, 1224\n1758 <-> 1346, 1541\n1759 <-> 196, 842\n1760 <-> 163, 729, 1125\n1761 <-> 170\n1762 <-> 891\n1763 <-> 410, 1763\n1764 <-> 309\n1765 <-> 1368\n1766 <-> 1031\n1767 <-> 898, 1955\n1768 <-> 360, 965\n1769 <-> 160\n1770 <-> 1079, 1868\n1771 <-> 575, 786\n1772 <-> 332\n1773 <-> 51, 910\n1774 <-> 347, 1122, 1130\n1775 <-> 1210\n1776 <-> 762, 1776\n1777 <-> 1948\n1778 <-> 833\n1779 <-> 571, 1435, 1779\n1780 <-> 434, 664, 1577\n1781 <-> 1958\n1782 <-> 147, 1106, 1397\n1783 <-> 1846\n1784 <-> 1784, 1866\n1785 <-> 1648, 1718, 1937\n1786 <-> 871\n1787 <-> 271, 1041\n1788 <-> 1295, 1962\n1789 <-> 1789\n1790 <-> 457, 638, 784\n1791 <-> 1708, 1791\n1792 <-> 1468\n1793 <-> 420\n1794 <-> 721\n1795 <-> 174, 614\n1796 <-> 852, 1414\n1797 <-> 511\n1798 <-> 107, 1427\n1799 <-> 812, 1109\n1800 <-> 988\n1801 <-> 684\n1802 <-> 670\n1803 <-> 1081, 1083\n1804 <-> 462\n1805 <-> 1236, 1409\n1806 <-> 789\n1807 <-> 1212, 1267\n1808 <-> 1841\n1809 <-> 1519, 1947\n1810 <-> 108, 453, 1167, 1943\n1811 <-> 139, 581, 734, 1955\n1812 <-> 1225, 1281, 1812\n1813 <-> 1602\n1814 <-> 1689\n1815 <-> 378\n1816 <-> 796, 1314\n1817 <-> 601, 1451\n1818 <-> 357\n1819 <-> 200, 1858\n1820 <-> 1834, 1904\n1821 <-> 1821\n1822 <-> 10, 859\n1823 <-> 694, 801, 864\n1824 <-> 353, 713, 909\n1825 <-> 224, 357\n1826 <-> 254, 1230\n1827 <-> 739, 793, 1221\n1828 <-> 1004, 1948\n1829 <-> 373\n1830 <-> 980\n1831 <-> 1831\n1832 <-> 140\n1833 <-> 1570\n1834 <-> 290, 1820\n1835 <-> 472, 1008\n1836 <-> 1420, 1963\n1837 <-> 1352\n1838 <-> 495\n1839 <-> 960\n1840 <-> 789, 1089, 1611\n1841 <-> 340, 1808\n1842 <-> 65, 1253\n1843 <-> 296\n1844 <-> 302, 1628\n1845 <-> 432, 892, 1971\n1846 <-> 330, 669, 1004, 1783\n1847 <-> 525\n1848 <-> 169, 996, 1304, 1711\n1849 <-> 57, 96\n1850 <-> 1517, 1972\n1851 <-> 32, 657\n1852 <-> 518\n1853 <-> 436, 692, 1042\n1854 <-> 354, 1854\n1855 <-> 619, 1855, 1893\n1856 <-> 745\n1857 <-> 1310\n1858 <-> 1458, 1731, 1819\n1859 <-> 555, 1004\n1860 <-> 440, 1714\n1861 <-> 228, 814\n1862 <-> 722, 1464, 1692\n1863 <-> 509\n1864 <-> 930, 1265, 1326\n1865 <-> 1552\n1866 <-> 389, 1784\n1867 <-> 1285, 1918\n1868 <-> 578, 1770, 1957\n1869 <-> 1660\n1870 <-> 672, 1664\n1871 <-> 799, 1006, 1749\n1872 <-> 1088\n1873 <-> 52, 569\n1874 <-> 1896\n1875 <-> 715, 963, 1177\n1876 <-> 94, 1189\n1877 <-> 392, 1371, 1484\n1878 <-> 41, 579, 1471\n1879 <-> 652\n1880 <-> 1162, 1880\n1881 <-> 1236\n1882 <-> 1299, 1349\n1883 <-> 482\n1884 <-> 348, 1670\n1885 <-> 757\n1886 <-> 117, 737, 1463\n1887 <-> 934, 1178\n1888 <-> 717\n1889 <-> 1899\n1890 <-> 754, 1201\n1891 <-> 155, 504\n1892 <-> 446, 507\n1893 <-> 1855\n1894 <-> 182\n1895 <-> 378, 650\n1896 <-> 524, 1874\n1897 <-> 1922\n1898 <-> 446\n1899 <-> 1713, 1889, 1899\n1900 <-> 1900\n1901 <-> 1295\n1902 <-> 247\n1903 <-> 37, 862, 1666\n1904 <-> 1820\n1905 <-> 502\n1906 <-> 294, 978\n1907 <-> 526, 566, 1128, 1348, 1400, 1546\n1908 <-> 1908\n1909 <-> 995, 1021, 1354\n1910 <-> 407\n1911 <-> 1204, 1621\n1912 <-> 647, 814, 852, 1016, 1262\n1913 <-> 565, 938, 1331\n1914 <-> 1126\n1915 <-> 411, 456, 1551\n1916 <-> 211\n1917 <-> 1033, 1946\n1918 <-> 1867\n1919 <-> 901, 1653\n1920 <-> 278, 653\n1921 <-> 47\n1922 <-> 1433, 1897\n1923 <-> 1654\n1924 <-> 339\n1925 <-> 1602, 1951\n1926 <-> 352, 1294\n1927 <-> 684, 1348\n1928 <-> 975\n1929 <-> 781, 899\n1930 <-> 1475, 1629, 1698\n1931 <-> 949\n1932 <-> 977\n1933 <-> 1059, 1087, 1612\n1934 <-> 756, 1934\n1935 <-> 145, 1448, 1756\n1936 <-> 379\n1937 <-> 1785\n1938 <-> 1547\n1939 <-> 532, 1686\n1940 <-> 429\n1941 <-> 431\n1942 <-> 1740, 1942\n1943 <-> 1064, 1810\n1944 <-> 1015\n1945 <-> 409, 1057, 1398, 1700\n1946 <-> 592, 601, 690, 1917\n1947 <-> 1423, 1809\n1948 <-> 883, 895, 1777, 1828\n1949 <-> 1949\n1950 <-> 1950\n1951 <-> 65, 1031, 1925\n1952 <-> 327\n1953 <-> 1323\n1954 <-> 15, 630, 1155\n1955 <-> 277, 1767, 1811\n1956 <-> 522, 900\n1957 <-> 1044, 1196, 1868\n1958 <-> 1340, 1506, 1781\n1959 <-> 125, 679\n1960 <-> 57, 194, 534, 863, 1960\n1961 <-> 1028\n1962 <-> 781, 1018, 1788\n1963 <-> 372, 1186, 1368, 1836\n1964 <-> 1012, 1964\n1965 <-> 484, 784\n1966 <-> 527, 1595\n1967 <-> 1431, 1967\n1968 <-> 587\n1969 <-> 656, 1604\n1970 <-> 882\n1971 <-> 539, 1280, 1416, 1721, 1845\n1972 <-> 889, 1039, 1186, 1850\n1973 <-> 251, 332, 629\n1974 <-> 1183\n1975 <-> 1975\n1976 <-> 1011\n1977 <-> 174, 579\n1978 <-> 662, 1282\n1979 <-> 205, 1065, 1074, 1677\n1980 <-> 268, 549, 833, 1143\n1981 <-> 786, 928\n1982 <-> 634, 1539\n1983 <-> 35, 1983\n1984 <-> 1984\n1985 <-> 477, 1985\n1986 <-> 257, 1656, 1986\n1987 <-> 1987\n1988 <-> 825\n1989 <-> 1624, 1668\n1990 <-> 1357\n1991 <-> 66, 738, 905, 1467\n1992 <-> 744, 950, 1592\n1993 <-> 779\n1994 <-> 326\n1995 <-> 1463\n1996 <-> 713\n1997 <-> 90, 513\n1998 <-> 447, 1500, 1722\n1999 <-> 12, 1537")

(deftest day12-test

  (testing "day12-test-part1"

    (is (= (contains-count "0 <-> 2\n1 <-> 1\n2 <-> 0, 3, 4\n3 <-> 2, 4\n4 <-> 2, 3, 6\n5 <-> 6\n6 <-> 4, 5" 0) 3))
    (is (= (contains-count input 0) 378)))

  (testing "day12-test-part2"

    (is (= (groups-count "0 <-> 2\n1 <-> 1\n2 <-> 0, 3, 4\n3 <-> 2, 4\n4 <-> 2, 3, 6\n5 <-> 6\n6 <-> 4, 5") 2))
    (is (= (groups-count input) 204))))