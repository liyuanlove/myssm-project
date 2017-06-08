$(function() {

    Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '2015 Q1',
            BM: 6852,
            CM: 15021,
            CS: 65221,
            WC: 121022,
            CSC: 3601
        }, {
            period: '2015 Q2',
            BM: 7000,
            CM: 16231,
            CS: 78464,
            WC: 132131,
            CSC: 2311
        }, {
            period: '2015 Q3',
            BM: 6786,
            CM: 14546,
            CS: 67654,
            WC: 163212,
            CSC: 2333
        }, {
            period: '2015 Q4',
            BM: 7021,
            CM: 18645,
            CS: 88888,
            WC: 142131,
            CSC: 2647
        }, {
            period: '2016 Q1',
            BM: 8367,
            CM: 21635,
            CS: 135431,
            WC: 522132,
            CSC: 1254
        }, {
            period: '2016 Q2',
            BM: 8567,
            CM: 25635,
            CS: 155431,
            WC: 552132,
            CSC: 1554
        }, {
            period: '2016 Q3',
            BM: 8667,
            CM: 26635,
            CS: 165431,
            WC: 562132,
            CSC: 1654
        }, {
            period: '2016 Q4',
            BM: 8767,
            CM: 27635,
            CS: 175431,
            WC: 572132,
            CSC: 1754
        }, {
            period: '2017 Q1',
            BM: 8867,
            CM: 28635,
            CS: 185431,
            WC: 582132,
            CSC: 1854
        }, {
            period: '2017 Q2',
            BM: 8967,
            CM: 29635,
            CS: 195431,
            WC: 592132,
            CSC: 1954
        }],
        xkey: 'period',
        ykeys: ['BM', 'CM', 'CS', 'WC', 'CSC'],
        labels: ['BM', 'CM', 'CS', 'WC', 'CSC'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });

    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "South Africa",
            value: 20
        }, {
            label: "Chile",
            value: 10
        }, {
            label: "Korea",
            value: 5
        }],
        resize: true
    });

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '2016-11',
            a: 1500,
            b: 6000,
            c: 8000,
            d: 15000,
            e: 500
        }, {
            y: '2016-12',
            a: 2000,
            b: 6000,
            c: 8900,
            d: 15320,
            e: 423
        }, {
            y: '2017-1',
            a: 1605,
            b: 5000,
            c: 7840,
            d: 16000,
            e: 325
        }, {
            y: '2017-2',
            a: 2300,
            b: 4500,
            c: 7745,
            d: 20000,
            e: 280
        }, {
            y: '2017-3',
            a: 1231,
            b: 7000,
            c: 9800,
            d: 16543,
            e: 630
        }, {
            y: '2017-4',
            a: 1531,
            b: 6546,
            c: 9880,
            d: 13521,
            e: 200
        }, {
            y: '2017-5',
            a: 1700,
            b: 5000,
            c: 9520,
            d: 18000,
            e: 280
        }],
        xkey: 'y',
        ykeys: ['a', 'b', 'c', 'd', 'e'],
        labels: ['BM', 'CM', 'CS', 'WC', 'CSC'],
        hideHover: 'auto',
        resize: true
    });
    
});
