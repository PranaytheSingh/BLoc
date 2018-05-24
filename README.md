
<h1 align="center">
  <br>
<img src="https://github.com/shitbox/BLoc/blob/master/images/b.png" width="200">
  <br>
  Bloc
  <br>
</h1>

<h4 align="center">A minimal configrable Blockchain for designing and prototyping Apps</h4>


<p align="center">
  <a href="#Why">Why</a> •
  <a href="#key-features">Key Features</a> •
  <a href="#how-to-use">How To Use</a> •
  <a href="#download">Download</a> •
  <a href="#credits">Credits</a> •
  <a href="#related">Related</a> •
  <a href="#license">License</a>
</p>

## Why

While trying to experiment with crypto assets and art we came across the need for a configurable blockchain interfacable over REST. Thus Bloc.

## Configrable Features

*  Miners - Control the number of Miners in the network.
* Blockchain Length - Control the final length of the Chain
* Difficutly - Control the difficulty of solving a Hash

## How To Use

To clone and run this application, you'll need [Git](https://git-scm.com), [Scala](https://scala-lang.org) and  [sbt](http://scala-sbt.org)) installed on your computer. From your command line:

```bash
# Clone this repository
$ git clone https://github.com/shitbox/BLoc

# Go into the repository
$ cd BLoc

# Install dependencies and run
$ sbt run

# This is will launch a server bound to 8888

```

## API
**GET /test** - Tests if server is Active and listening 

**GET /v1/:miner/start** - Start mining blocks by passing any one of the Client names from the [Registry](https://github.com/shitbox/BLoc/blob/master/src/main/scala/com/pranay/blockchain/Config.scala). You can have as many Clients as long as you specify them in the registry.

**GET /v1/final** - Get a JSON Blockchain manifest specifying blockchain info such as block hash, block minedBy.

## Sample Output

```
.
.
.
- block 93 mined by: Client1 HASH: 0002a41f6874e2983f52b9871ba026a898cb534991b597c70a646cd0a6bc6fd2
- block 94 mined by: Client4 HASH: 000d2f9268565118630ed4faca659bdb401e4cd59bc30b5da93cdc0fe804ae9c
- block 95 mined by: Client1 HASH: 000f47869182399a22a93e5307e62a38ed1ec1159cad1d05a31d519981c5cd0b
- block 96 mined by: Client4 HASH: 000b0e63325a53dea459064e11b8c9c1c6c21ae65ae01e7e56fdbfa239b5c819
- block 97 mined by: Client3 HASH: 00070d9c6542e39fa7a1fc8d61543932d2cd0a16f043d5a8a3f417e5e5d34379
- block 98 mined by: Client2 HASH: 000367ea721822746b459f9d02644eb751293ebd124df801022fc06e5c165d4c
.
.
```

## License

MIT

---

> GitHub [@shitbox](https://github.com/shitbox) &nbsp;&middot;&nbsp;
> Email zeppez@protonmail.com



