# Memory Efficient Trie

Imagine a trie storing the words "bee", "beekeeper", and "zoo". In a normal trie, we would just have nodes for each character, despite character repeats.

1. How could you modify the trie such that repeating characters don't make duplicate nodes in the trie?

2. Draw out what your new memory efficient Trie would look like if we inserted the words "bee", "beekeeper", "buzz", and "brrrrrr"

3. When do you expect this Memory Efficient form of trie to use less memory than regular ones? When would it use more?


Solutions:
1. Add a field in the Trie Nodes to keep track of how many repeats of the character there are
2. Should look something like this
![Should look like this](https://lh3.googleusercontent.com/cFtj5G4Dzfz6_JeAP9DIzEvlEk8NqXgBS236GcO6ne9A5l60sqWTSEveubEIAT7Ma6Vv1Qljj-g24ZigMKCgyzivBzm2FHaOoMPZyd_IExwxLKCgE-iId8twiGby4j-MfbY35Iytww3tfI8WSqO2_HfFF69dp6OrxFrJw2Bm457zPPc5fwFb5dmSQurg88DjCznLdxGnTluMeLmyC_RYbTUbUbrqvvtHkojzv1fpI8k4KJE6cNdhN-e9Cx4NY_XJfHyYJilS-flgabeH5PIi3qBsBoBdyFAELJYck6KOkcjTs7MhiFi62yzGcwlSrqOuo3FNX-yOdhaz5axRRRpSh0stCpTkNRCw7gDPFPW2v4oxWse-d395a_U8N_TNErBCaeo47533MTnWQSBF7v1cbHoaJ_9tCRh7nTPXSmmhjqZTYuAzh81FiqTdDInEHVkGXFHjbXeIOcxwMo-2AIWtI4xwhOU-cypkZ3PILoNNDh8LAVoyS_MUXhczdHxh_ashW7lFsBVXssfuaAUsJHGgPtmTxCAdDjN7RhT2Avc0WjoQtvDTzO4a45iWSjkEzE2jVn3EYDOyUdWtPntzKtwLZz70IStquf72NZgUG1Rk0DWB_ASojJvYlrFEe0w79Ueg6jk-d7zxsmeqnE9bcYXWKWJUfpi-KAV7mlz583YOxS3Hy4H2ziJlTYg1-ioKVHk=w756-h1007-no?authuser=0)
3. If there's lots of repeated characters, it should save some space. If there's very few, it would take more space because it keeps track of a repeat count.
