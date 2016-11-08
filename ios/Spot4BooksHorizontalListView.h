//
//  Spot4BooksHorizontalListView.h
//  genas
//
//  Created by Henadzi Stoma on 11/3/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "RCTView.h"
#import "SimpleItemObject.h"
#import "Spot4BooksCell.h"

@interface Spot4BooksHorizontalListView : RCTView <UICollectionViewDataSource, UICollectionViewDelegate>

  @property (nonatomic, retain) BooksData *_itemsArray;
- (void) initCollection;

@end
