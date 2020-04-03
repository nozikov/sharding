# sharding

### Create Table `user`:

```postgresql
CREATE TABLE "user" (
    id BIGINT PRIMARY KEY,
    name CHARACTER NOT NULL,
    balance INTEGER
)
```

### Create Table `payment`:

```postgresql
CREATE TABLE "payment" (
    id BIGINT PRIMARY KEY,
    amount INTEGER NOT NULL,
    sender "user" NOT NULL,
    recipient "user" NOT NULL
)
```

### Create Tables with using partitioning:
#### With rank `amount` from 0 to 1K:

```postgresql
CREATE TABLE "payment_amount_0_1K" (
    CHECK (amount <= 1000)
) INHERITS (payment)
```

#### With rank `amount` from 1K to 100K:

```postgresql
CREATE TABLE "payment_amount_1K_100K" (
    CHECK (amount > 1000 AND amount <= 100000)
) INHERITS (payment)
```

#### With rank `amount` from 100K to INFINITY:

```postgresql
CREATE TABLE "payment_amount_100K_INF" (
    CHECK (amount > 100000)
) INHERITS (payment)
```
