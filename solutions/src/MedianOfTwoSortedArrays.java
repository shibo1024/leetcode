/**
 * description:
 *
 * @author zhangshibo  [2017/6/7].
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 > l2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int imin = 0;
        int imax = l1;
        int halfLen = (l1 + l2 + 1) / 2;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;
            if (i < l1 && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                int maxOfLeft;
                if (i == 0) {
                    maxOfLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1];
                } else {
                    maxOfLeft = (nums1[i - 1] > nums2[j - 1]) ? nums1[i - 1] : nums2[j - 1];
                }
                if ((l1 + l2) % 2 == 1) {
                    return maxOfLeft;
                }
                int minOfRight;
                if (i == l1) {
                    minOfRight = nums2[j];
                } else if (j == l2) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = (nums1[i] < nums2[j]) ? nums1[i] : nums2[j];
                }

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums1 = {24, 26, 30, 44, 45, 71, 173, 207, 251, 287, 296, 300, 335, 412, 430, 453, 457, 469, 594, 601, 614, 649, 681, 717, 744, 744, 763, 793, 799, 808, 848, 922, 945, 975, 1019, 1045, 1062, 1065, 1066, 1128, 1170, 1187, 1188, 1242, 1270, 1431, 1491, 1507, 1552, 1579, 1593, 1610, 1616, 1627, 1682, 1694, 1695, 1741, 1793, 1817, 1830, 1837, 1950, 1981, 2019, 2052, 2053, 2073, 2087, 2097, 2099, 2155, 2165, 2167, 2192, 2214, 2216, 2322, 2336, 2366, 2369, 2389, 2477, 2478, 2480, 2522, 2531, 2588, 2606, 2606, 2656, 2657, 2676, 2811, 2923, 2924, 2927, 2933, 2995, 3050, 3056, 3106, 3172, 3198, 3258, 3296, 3302, 3306, 3355, 3411, 3433, 3478, 3483, 3501, 3560, 3580, 3608, 3697, 3907, 3943, 3968, 3983, 3985, 4077, 4080, 4092, 4183, 4216, 4247, 4386, 4432, 4477, 4503, 4556, 4613, 4640, 4683, 4693, 4750, 4760, 4773, 4775, 4911, 4950, 4952, 4957, 4958, 4961, 5005, 5031, 5039, 5042, 5049, 5069, 5076, 5118, 5171, 5196, 5219, 5233, 5287, 5294, 5316, 5364, 5386, 5392, 5525, 5646, 5672, 5678, 5683, 5690, 5719, 5757, 5781, 6041, 6050, 6051, 6178, 6189, 6227, 6229, 6242, 6256, 6300, 6348, 6386, 6416, 6486, 6488, 6489, 6545, 6552, 6671, 6725, 6728, 6752, 6759, 6776, 6872, 6885, 6898, 6923, 6937, 6985, 7021, 7023, 7031, 7048, 7187, 7220, 7233, 7257, 7281, 7296, 7329, 7338, 7346, 7375, 7379, 7380, 7439, 7519, 7538, 7538, 7588, 7592, 7595, 7605, 7616, 7625, 7655, 7697, 7708, 7810, 7883, 7889, 7902, 7917, 7934, 7962, 7993, 8019, 8034, 8099, 8100, 8103, 8191, 8227, 8235, 8239, 8260, 8283, 8322, 8327, 8391, 8393, 8471, 8510, 8519, 8533, 8626, 8632, 8650, 8673, 8678, 8801, 8850, 8851, 8884, 8895, 8995, 9015, 9025, 9101, 9114, 9159, 9175, 9195, 9234, 9244, 9247, 9250, 9334, 9349, 9355, 9363, 9386, 9391, 9414, 9521, 9564, 9700, 9877, 9899, 9953, 9968, 10032, 10036, 10038, 10041, 10052, 10116, 10179, 10193, 10202, 10208, 10310, 10317, 10334, 10339, 10396, 10435, 10444, 10487, 10539, 10539, 10689, 10766, 10823, 10937, 10937, 10954, 10985, 11016, 11069, 11093, 11095, 11179, 11180, 11198, 11204, 11218, 11224, 11407, 11489, 11521, 11548, 11564, 11576, 11626, 11650, 11680, 11730, 11848, 11848, 11851, 11910, 11968, 12025, 12050, 12076, 12079, 12165, 12170, 12184, 12192, 12213, 12236, 12311, 12321, 12322, 12329, 12354, 12362, 12364, 12407, 12435, 12510, 12526, 12539, 12582, 12592, 12644, 12697, 12743, 12790, 12864, 12989, 13018, 13046, 13054, 13097, 13099, 13147, 13149, 13174, 13230, 13273, 13299, 13310, 13353, 13383, 13447, 13547, 13563, 13565, 13574, 13611, 13658, 13669, 13680, 13778, 13812, 13879, 13881, 13897, 13923, 13933, 13941, 13959, 13986, 14016, 14063, 14114, 14178, 14199, 14263, 14325, 14424, 14480, 14492, 14502, 14579, 14689, 14738, 14764, 14782, 14845, 14852, 14908, 14923, 14998, 15023, 15028, 15064, 15086, 15148, 15149, 15160, 15186, 15311, 15444, 15499, 15621, 15657, 15677, 15694, 15821, 15822, 15901, 15928, 15956, 15970, 15975, 16086, 16094, 16095, 16098, 16114, 16158, 16196, 16197, 16351, 16389, 16394, 16420, 16442, 16534, 16582, 16594, 16597, 16602, 16688, 16689, 16689, 16710, 16828, 16956, 16970, 17054, 17098, 17142, 17142, 17148, 17169, 17184, 17220, 17260, 17264, 17281, 17303, 17307, 17360, 17361, 17408, 17496, 17572, 17633, 17646, 17679, 17730, 17750, 17804, 17824, 17898, 17927, 17957, 17972, 18029, 18033, 18070, 18075, 18080, 18115, 18145, 18157, 18307, 18321, 18328, 18348, 18367, 18411, 18416, 18422, 18464, 18517, 18526, 18553, 18566, 18601, 18649, 18655, 18676, 18678, 18696, 18709, 18725, 18943, 18977, 19010, 19021, 19046, 19056, 19084, 19094, 19095, 19109, 19109, 19112, 19171, 19197, 19226, 19228, 19254, 19283, 19305, 19325, 19391, 19479, 19496, 19509, 19524, 19547, 19557, 19581, 19586, 19594, 19672, 19707, 19793, 19856, 19856, 19867, 19870, 19883, 19885, 19893, 19980, 19996, 20045, 20069, 20115, 20119, 20172, 20172, 20205, 20255, 20259, 20262, 20267, 20281, 20405, 20413, 20485, 20536, 20547, 20550, 20572, 20574, 20642, 20642, 20665, 20682, 20690, 20794, 20857, 20871, 20885, 20984, 21049, 21063, 21076, 21077, 21085, 21097, 21126, 21128, 21130, 21202, 21316, 21320, 21383, 21384, 21390, 21391, 21417, 21454, 21518, 21550, 21606, 21607, 21613, 21638, 21638, 21671, 21714, 21733, 21748, 21785, 21786, 21804, 21807, 21828, 21877, 21902, 21925, 21967, 21972, 21976, 21986, 21995, 22006, 22022, 22023, 22041, 22041, 22072, 22124, 22140, 22181, 22184, 22204, 22209, 22225, 22229, 22238, 22250, 22262, 22348, 22362, 22427, 22430, 22444, 22576, 22592, 22617, 22660, 22747, 22760, 22773, 22774, 22779, 22806, 22873, 22901, 22931, 22933, 22954, 22988, 23046, 23071, 23102, 23112, 23112, 23135, 23168, 23169, 23187, 23188, 23210, 23288, 23330, 23359, 23382, 23411, 23414, 23444, 23481, 23493, 23540, 23559, 23572, 23609, 23674, 23683, 23724, 23758, 23976, 24029, 24048, 24173, 24201, 24219, 24249, 24287, 24294, 24310, 24386, 24413, 24445, 24473, 24555, 24573, 24616, 24639, 24642, 24668, 24671, 24687, 24694, 24704, 24720, 24725, 24891, 24927, 24934, 24967, 24980, 25058, 25084, 25091, 25101, 25120, 25131, 25147, 25203, 25292, 25293, 25319, 25322, 25370, 25393, 25450, 25513, 25536, 25617, 25621, 25663, 25666, 25727, 25729, 25743, 25749, 25753, 25765, 25795, 25804, 25831, 25885, 25909, 25929, 25937, 25944, 25960, 25986, 26014, 26017, 26044, 26049, 26086, 26089, 26090, 26108, 26147, 26201, 26201, 26216, 26281, 26382, 26412, 26466, 26468, 26492, 26499, 26513, 26612, 26698, 26855, 26881, 26900, 26913, 26920, 26990, 27048, 27064, 27079, 27159, 27163, 27188, 27259, 27296, 27303, 27311, 27351, 27361, 27371, 27386, 27403, 27485, 27536, 27545, 27553, 27566, 27595, 27610, 27685, 27685, 27714, 27780, 27824, 27867, 27877, 27956, 27962, 28048, 28054, 28086, 28095, 28122, 28130, 28135, 28161, 28168, 28199, 28208, 28220, 28253, 28291, 28324, 28359, 28385, 28452, 28455, 28482, 28495, 28567, 28702, 28756, 28846, 28860, 28913, 28962, 29057, 29102, 29106, 29124, 29133, 29143, 29147, 29210, 29247, 29264, 29264, 29290, 29331, 29341, 29345, 29345, 29349, 29356, 29380, 29398, 29425, 29431, 29433, 29464, 29474, 29480, 29532, 29570, 29585, 29624, 29648, 29658, 29684, 29783, 29787, 29798, 29878, 29900, 29947, 29961, 29977, 30020, 30048, 30060, 30111, 30117, 30121, 30164, 30231, 30339, 30385, 30416, 30533, 30549, 30586, 30589, 30604, 30616, 30648, 30660, 30672, 30685, 30711, 30748, 30787, 30848, 30850, 30860, 30869, 30870, 30879, 30879, 30909, 30982, 30997, 31045, 31246, 31289, 31314, 31361, 31401, 31438, 31450, 31452, 31457, 31525, 31594, 31596, 31626, 31650, 31660, 31668, 31686, 31696, 31720, 31728, 31761, 31762, 31860, 31914, 31981, 31983, 31991, 32035, 32042, 32110, 32148, 32184, 32190, 32208, 32212, 32240, 32250, 32266, 32293, 32323, 32387, 32396, 32506, 32613, 32646, 32661, 32664, 32719, 32720, 32762, 32766};
        int[] nums2 = {15, 117, 132, 145, 155, 212, 333, 342, 372, 418, 439, 439, 453, 462, 462, 468, 544, 606, 730, 767, 798, 801, 814, 885, 887, 920, 936, 941, 943, 981, 985, 1003, 1019, 1065, 1113, 1177, 1219, 1233, 1272, 1378, 1387, 1388, 1394, 1406, 1597, 1607, 1631, 1634, 1639, 1640, 1686, 1791, 1804, 1817, 1822, 1839, 1847, 1861, 1886, 1921, 1922, 1933, 1944, 1952, 1956, 1964, 1978, 2025, 2036, 2049, 2067, 2081, 2124, 2154, 2168, 2170, 2206, 2227, 2233, 2256, 2272, 2317, 2334, 2345, 2414, 2455, 2457, 2530, 2553, 2565, 2568, 2591, 2646, 2654, 2689, 2695, 2753, 2765, 2786, 2791, 2797, 2808, 2844, 2913, 2951, 2965, 3002, 3010, 3011, 3082, 3086, 3100, 3145, 3221, 3225, 3225, 3243, 3298, 3304, 3322, 3395, 3410, 3418, 3427, 3445, 3581, 3618, 3734, 3744, 3769, 3899, 3903, 3914, 3922, 3978, 3999, 4001, 4023, 4195, 4208, 4244, 4313, 4361, 4381, 4392, 4403, 4421, 4431, 4451, 4530, 4576, 4577, 4683, 4706, 4719, 4735, 4814, 4817, 4838, 4850, 4869, 4931, 4958, 4962, 4969, 4980, 4982, 5002, 5009, 5095, 5131, 5143, 5182, 5186, 5211, 5231, 5263, 5264, 5286, 5311, 5378, 5399, 5455, 5554, 5592, 5618, 5629, 5652, 5679, 5713, 5752, 5775, 5784, 5803, 5928, 5936, 5963, 5977, 5984, 6026, 6031, 6037, 6052, 6106, 6148, 6153, 6246, 6266, 6275, 6383, 6402, 6405, 6417, 6471, 6498, 6508, 6603, 6615, 6647, 6699, 6705, 6716, 6749, 6771, 6865, 6950, 6990, 7016, 7020, 7063, 7081, 7086, 7110, 7119, 7143, 7221, 7231, 7305, 7344, 7368, 7426, 7431, 7473, 7492, 7494, 7603, 7605, 7643, 7661, 7707, 7712, 7726, 7733, 7768, 7797, 7833, 7848, 7890, 7923, 8027, 8070, 8082, 8124, 8133, 8156, 8168, 8314, 8325, 8335, 8340, 8393, 8402, 8405, 8413, 8535, 8554, 8581, 8582, 8648, 8668, 8695, 8695, 8737, 8787, 8824, 8852, 9010, 9016, 9052, 9055, 9072, 9133, 9175, 9207, 9223, 9254, 9260, 9300, 9329, 9358, 9361, 9367, 9386, 9393, 9399, 9409, 9418, 9423, 9424, 9479, 9507, 9587, 9596, 9618, 9642, 9643, 9669, 9740, 9744, 9765, 9781, 9818, 9888, 9900, 9914, 9934, 9989, 10036, 10037, 10108, 10110, 10111, 10113, 10245, 10277, 10300, 10346, 10354, 10365, 10426, 10428, 10440, 10477, 10539, 10544, 10581, 10591, 10678, 10685, 10696, 10722, 10749, 10760, 10774, 10790, 10846, 10847, 10866, 10896, 10979, 11036, 11094, 11151, 11167, 11197, 11267, 11347, 11477, 11481, 11492, 11521, 11693, 11727, 11797, 11831, 11919, 11972, 11973, 12020, 12048, 12054, 12218, 12260, 12286, 12311, 12355, 12365, 12403, 12432, 12470, 12515, 12524, 12539, 12561, 12654, 12714, 12731, 12801, 12826, 12841, 12891, 12951, 12967, 12988, 12991, 13027, 13051, 13157, 13181, 13206, 13238, 13263, 13274, 13293, 13344, 13405, 13436, 13536, 13539, 13543, 13547, 13596, 13604, 13617, 13652, 13676, 13700, 13708, 13719, 13888, 13935, 13939, 13941, 13986, 13995, 14051, 14062, 14065, 14110, 14179, 14250, 14355, 14364, 14395, 14413, 14521, 14554, 14572, 14587, 14587, 14635, 14656, 14656, 14789, 14794, 14799, 14813, 14880, 14913, 14941, 14996, 15024, 15028, 15064, 15083, 15090, 15105, 15114, 15170, 15204, 15262, 15320, 15357, 15391, 15416, 15419, 15424, 15501, 15514, 15531, 15534, 15549, 15609, 15625, 15661, 15735, 15762, 15764, 15779, 15806, 15836, 15855, 15894, 15933, 15938, 16056, 16104, 16119, 16195, 16205, 16206, 16212, 16299, 16303, 16309, 16323, 16325, 16337, 16349, 16395, 16414, 16431, 16460, 16463, 16465, 16465, 16474, 16480, 16501, 16562, 16608, 16705, 16735, 16750, 16763, 16778, 16813, 16849, 16877, 16882, 16891, 16896, 16911, 16971, 17053, 17057, 17102, 17120, 17225, 17280, 17303, 17334, 17338, 17529, 17544, 17699, 17702, 17836, 17851, 17855, 17938, 17951, 18020, 18085, 18087, 18108, 18124, 18135, 18162, 18168, 18168, 18182, 18186, 18203, 18218, 18221, 18228, 18232, 18239, 18280, 18312, 18333, 18457, 18495, 18632, 18655, 18659, 18662, 18676, 18743, 18767, 18919, 18978, 19113, 19137, 19159, 19179, 19189, 19197, 19207, 19259, 19269, 19303, 19419, 19499, 19533, 19539, 19560, 19602, 19649, 19698, 19724, 19879, 19884, 19962, 20032, 20041, 20096, 20105, 20106, 20132, 20148, 20198, 20201, 20329, 20337, 20415, 20420, 20458, 20538, 20561, 20569, 20640, 20649, 20665, 20669, 20690, 20757, 20766, 20847, 20961, 21033, 21045, 21061, 21084, 21096, 21125, 21149, 21192, 21201, 21219, 21287, 21304, 21350, 21360, 21369, 21384, 21437, 21500, 21503, 21544, 21577, 21609, 21615, 21625, 21633, 21665, 21701, 21792, 21806, 21847, 21861, 21876, 21894, 21923, 21968, 22027, 22039, 22165, 22182, 22197, 22213, 22216, 22232, 22295, 22309, 22329, 22366, 22390, 22407, 22427, 22452, 22507, 22515, 22563, 22564, 22600, 22649, 22659, 22662, 22696, 22698, 22731, 22731, 22740, 22769, 22790, 22793, 22808, 22843, 22862, 22894, 22974, 23042, 23067, 23074, 23077, 23100, 23103, 23132, 23147, 23151, 23188, 23277, 23298, 23317, 23325, 23423, 23465, 23479, 23494, 23526, 23538, 23567, 23639, 23671, 23715, 23717, 23826, 23861, 23871, 23910, 23924, 23946, 23951, 23958, 23987, 23991, 24001, 24009, 24039, 24040, 24103, 24134, 24180, 24200, 24230, 24283, 24291, 24321, 24505, 24541, 24541, 24646, 24649, 24666, 24740, 24743, 24745, 24780, 24785, 24802, 24841, 24866, 24867, 24876, 24890, 24960, 24981, 24998, 25012, 25067, 25120, 25121, 25154, 25167, 25169, 25182, 25183, 25207, 25236, 25292, 25347, 25460, 25466, 25468, 25474, 25481, 25505, 25518, 25560, 25568, 25585, 25603, 25606, 25668, 25802, 25840, 25846, 25860, 25889, 26002, 26011, 26019, 26147, 26171, 26173, 26208, 26237, 26250, 26277, 26330, 26349, 26391, 26585, 26598, 26599, 26613, 26624, 26688, 26730, 26768, 26795, 26818, 26829, 26844, 26852, 26855, 26861, 26884, 26942, 26998, 26999, 27000, 27002, 27015, 27084, 27132, 27140, 27148, 27213, 27237, 27267, 27289, 27317, 27378, 27389, 27393, 27396, 27458, 27493, 27558, 27570, 27610, 27610, 27630, 27633, 27636, 27648, 27668, 27740, 27741, 27802, 27846, 28010, 28034, 28079, 28100, 28184, 28202, 28215, 28313, 28449, 28469, 28485, 28488, 28506, 28517, 28523, 28559, 28567, 28578, 28596, 28759, 28801, 28898, 28941, 28954, 28994, 29022, 29044, 29115, 29168, 29258, 29258, 29275, 29276, 29345, 29352, 29385, 29470, 29476, 29489, 29499, 29529, 29568, 29637, 29639, 29678, 29698, 29767, 29800, 29818, 29822, 29828, 29857, 29873, 29913, 29917, 29933, 29989, 30130, 30141, 30157, 30236, 30259, 30274, 30321, 30349, 30361, 30367, 30402, 30471, 30476, 30657, 30717, 30762, 30778, 30848, 30880, 30899, 30923, 30950, 30954, 31157, 31159, 31206, 31222, 31231, 31246, 31264, 31330, 31348, 31349, 31354, 31371, 31398, 31455, 31462, 31470, 31498, 31515, 31574, 31581, 31603, 31611, 31639, 31677, 31679, 31757, 31830, 31917, 32038, 32051, 32054, 32063, 32070, 32091, 32094, 32111, 32211, 32219, 32265, 32267, 32367, 32396, 32403, 32408, 32493, 32504, 32522, 32543, 32559, 32590, 32659, 32671, 32690, 32695, 32731, 32745};

        double result = new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(result);

        System.out.println(System.currentTimeMillis() - start);
    }
}
