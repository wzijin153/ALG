支持将snapshot表的OfferPrice, BidPrice, OfferOrderQty, BidOrderQty每一档单独存一列
demo.txt: 使用示例

存放路径:
snapshotVectorSchema.dos /DolphinDBModules/easyTLDataImport/tbSchema/
loadOneDaySnapshotVector.dos /DolphinDBModules/easyTLDataImport/loadOneDayData/
createTBsnapshotVector.dos /DolphinDBModules/easyTLDataImport/
loadTLDatasnapshotVector.dos /DolphinDBModules/easyTLDataImport/

以上文件存入相应路径之后, 需要使用clearCachedModules(), 清除缓存module之后即可使用