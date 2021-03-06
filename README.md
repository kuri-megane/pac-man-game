[![Maintainability](https://api.codeclimate.com/v1/badges/0486eae61dc0c74bf8de/maintainability)](https://codeclimate.com/github/kuri-megane/pac-man-game/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/0486eae61dc0c74bf8de/test_coverage)](https://codeclimate.com/github/kuri-megane/pac-man-game/test_coverage)
[![CircleCI](https://circleci.com/gh/kuri-megane/pac-man-game.svg?style=svg&circle-token=391312073f6a90d144f9ac3b8c84c2bf42f2dcdf)](https://circleci.com/gh/kuri-megane/pac-man-game)
[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](LICENSE)
![Develop By MacOS](https://img.shields.io/badge/Confirm%20by-macOS-blue.svg)

# Pac Man Game

パックマン風ゲーム

CLIでプレイするパックマン風ゲーム．
Javaで書いてます．

# How to play

![フレイ動画](https://user-images.githubusercontent.com/43510592/68592999-c6528d00-04d7-11ea-859a-aa73a22ed33f.gif)

and [See YouTube](https://youtu.be/W1M-HNycAs8)

```bash
$ mvn install -DskipTests=true
$ mvn exec:java -Dexec.mainClass="io.github.kuri_megane.Main"
```

# Rule

1. パックマン(○)とモンスター(x)のクッキー(★)取り合い合戦です．
2. パックマンを矢印キーで動かしてクッキーを取りにいきましょう．
3. モンスターより多くのクッキーを取ってください．
4. パックマンがモンスターに捕まるとゲームオーバーです.
5. すべてのクッキーがなくなったらゲーム終了です.

# Dependency & Requirements

- [Java SDK Amazon Corretto 8](https://docs.aws.amazon.com/ja_jp/corretto/latest/corretto-8-ug/downloads-list.html)
- [maven](https://maven.apache.org/)

# Documentation

- [Javadoc](https://kuri-megane.github.io/pac-man-game/) : in the `/docs` folder.

# Develop Management

- [Trello](https://trello.com/b/EcY2TEAx)


# Licence
This software is released under the MIT License, see LICENSE.

# Authors

- [Kuri Megane](https://github.com/kuri-megane)
