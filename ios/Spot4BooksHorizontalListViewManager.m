//
//  Spot4BooksHorizontalListViewManager.m
//  genas
//
//  Created by Henadzi Stoma on 11/3/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksHorizontalListViewManager.h"
#import "Spot4BooksHorizontalListView.h"

@implementation Spot4BooksHorizontalListViewManager

RCT_EXPORT_MODULE()
- (UIView *)view
{
  Spot4BooksHorizontalListView *listView = [[Spot4BooksHorizontalListView alloc] init];
  return listView;
}

@end
