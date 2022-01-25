# URL
https://qiita.com/e869120/items/eb50fdaece12be418faa

# 反省点

## 過去問

### Problem3

- 終了時のcurrentの値を更新するのを忘れていた。**最後の要素まで判定の対象とする。**

### Problem4
- 𝑁 ≤ 100, 𝐴𝑖,𝑗 ≤ 108 なので答えは 10^10 まであり得てしまう。int 型は 2.14 × 10^9 程度まで。

### Problem6
- 全探索を行う対象は何かを考える。(入力を対象にした方が解きやすいのか、期待値を対象にした方が解きやすいのか etc...)

### Problem8
- 𝑁 個の数 𝑎1, 𝑎2, 𝑎3, … , 𝑎𝑁 があります。 |𝑥 − 𝑎1| + |𝑥 − 𝑎2| + ⋯ + |𝑥 − 𝑎𝑁| の最小値は「𝑎1, 𝑎2, 𝑎3, … , 𝑎𝑁 の中央値」となる。これは先の式を微分して傾きを求めると、 x が ai の中央値の場合に0となるため。

## 20220122
https://atcoder.jp/contests/arc133

### A
- 辞書配列 -> 先頭の文字がなるべく辞書順上位の値になるような探索を行う(2よりも1, bよりもa etc...)

### B
- lower_bound, LIS, LCS が理解できていれば解けた問題
  - https://qiita.com/ageprocpp/items/f6661deaa09dda124132
  - https://qiita.com/_rdtr/items/c49aa20f8d48fbea8bd2
  - https://qiita.com/ganyariya/items/33f1326154b85db465c3