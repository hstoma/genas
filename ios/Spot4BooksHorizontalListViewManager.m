//
//  Spot4BooksHorizontalListViewManager.m
//  genas
//
//  Created by Henadzi Stoma on 11/3/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksHorizontalListViewManager.h"
#import "Spot4BooksHorizontalListView.h"
#import "RCTConvert+BooksData.h"

@implementation Spot4BooksHorizontalListViewManager {
  Spot4BooksHorizontalListView *listView;
}

RCT_EXPORT_MODULE()
- (UIView *)view
{
  listView = [[Spot4BooksHorizontalListView alloc] init];
  return listView;
}

RCT_CUSTOM_VIEW_PROPERTY(bookList, BooksData , Spot4BooksHorizontalListView) {
  BooksData *data = json ? [RCTConvert BooksData:json] : nil;
  if (data!=nil) {
    listView._itemsArray = data;
    NSLog(@"===============%@", listView._itemsArray);
    [listView initCollection];
  }
}

@end
