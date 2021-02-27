# Challenge #1: Bitcoin Tickers

Bespoke Bitcoin Solutions Ltd. have hired you as an engineer for their new project. You are required to write an
application to compare bitcoin prices.

## Specifications

- Write an application to consume from 2 **REST APIs**.
- You must compare the **BTC** -> **USD** exchange rate for each one and output the lowest **sell** price.

## Endpoints

Below is information about the two endpoints.

Name       | URL                                                  | 
-----------|------------------------------------------------------|
Blockchain | https://blockchain.info/ticker                       | 
Bitcoin    | https://api.exchange.bitcoin.com/api/2/public/ticker |

### Blockchain Example Response

```json
{
  "USD": {
    "15m": 47670.39,
    "last": 47670.39,
    "buy": 47670.39,
    "sell": 47670.39,
    "symbol": "$"
  },
  ...
}
```

### Bitcoin Example Response
```json
[
  ...,
{
    "symbol": "BTCUSD",
    "ask": "47514.89",
    "bid": "47511.47",
    "last": "47497.40",
    "low": "45080.00",
    "high": "48410.00",
    "open": "46976.00",
    "volume": "22233.49052",
    "volumeQuote": "1045074947.1505288",
    "timestamp": "2021-02-27T12:43:34.888Z"
  },
...
]
```

## Rules

You will be scored on the follow critera:

- Good use of [design patterns](https://sourcemaking.com/design_patterns).
- Testing.
- Code readability.
- Code runnability.

The code will be pushed to a public git repo.