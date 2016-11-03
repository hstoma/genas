//
//  Spot4BooksHorizontalListView.m
//  genas
//
//  Created by Henadzi Stoma on 11/3/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksHorizontalListView.h"
#import "UIView+React.h"

@implementation Spot4BooksHorizontalListView {
  UICollectionView *_collectionView;
  NSMutableArray *_itemsArray;
}


- (instancetype)init
{
  if ((self = [super init])) {
    UICollectionViewFlowLayout* flowLayout = [[UICollectionViewFlowLayout alloc] init];
    [flowLayout setItemSize:CGSizeMake(200, 200)];
    [flowLayout setScrollDirection:UICollectionViewScrollDirectionHorizontal];
    _collectionView = [[UICollectionView alloc] initWithFrame:self.frame collectionViewLayout:flowLayout];
    [_collectionView registerClass:[Spot4BooksCell class] forCellWithReuseIdentifier:@"Spot4BooksCell"];
    [_collectionView setBackgroundColor:[UIColor clearColor]];
    _itemsArray = [[NSMutableArray alloc] init];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 1" withWidth:150. andHeight:240.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 2" withWidth:120. andHeight:240.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 3" withWidth:250. andHeight:240.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 4" withWidth:170. andHeight:240.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 5" withWidth:230. andHeight:240.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 6" withWidth:350. andHeight:240.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 7" withWidth:150. andHeight:240.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 8" withWidth:100. andHeight:240.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 9" withWidth:180. andHeight:240.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 10" withWidth:190. andHeight:240.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 11" withWidth:100. andHeight:240.]];
    
    [_collectionView setDelegate:self];
    [_collectionView setDataSource:self];
    [self addSubview:_collectionView];
  }
  return self;
}


- (void) initItemsForCollection {
  _itemsArray = [[NSMutableArray alloc] init];
  
}


- (void)reactSetFrame:(CGRect)frame
{
  [super reactSetFrame: frame];
  if (_collectionView!=nil) {
    [_collectionView setFrame:frame];
  }
}


- (NSInteger)collectionView:(UICollectionView *)collectionView numberOfItemsInSection:(NSInteger)section {
  NSLog(@"----------------------1----%lu", (unsigned long)[_itemsArray count]);
  return [_itemsArray count];
}


- (CGSize)collectionView:(UICollectionView *)collectionView layout:(UICollectionViewLayout*)collectionViewLayout sizeForItemAtIndexPath:(NSIndexPath *)indexPath{
  SimpleItemObject* obj = [_itemsArray objectAtIndex:indexPath.item];
  return CGSizeMake(obj.width, obj.height);
}

- (__kindof UICollectionViewCell *)collectionView:(UICollectionView *)collectionView cellForItemAtIndexPath:(NSIndexPath *)indexPath {
  NSLog(@"----------------------2");
  
  static NSString *cellIdentifier = @"Spot4BooksCell";
  
  /*  Uncomment this block to use nib-based cells */
  // UICollectionViewCell *cell = [collectionView dequeueReusableCellWithReuseIdentifier:cellIdentifier forIndexPath:indexPath];
  // UILabel *titleLabel = (UILabel *)[cell viewWithTag:100];
  // [titleLabel setText:cellData];
  /* end of nib-based cell block */
  
  /* Uncomment this block to use subclass-based cells */
  Spot4BooksCell *cell = (Spot4BooksCell *)[collectionView dequeueReusableCellWithReuseIdentifier:cellIdentifier forIndexPath:indexPath];
  SimpleItemObject* obj = [_itemsArray objectAtIndex:indexPath.item];
  //[cell setFrame:CGRectMake(0, 0, obj.width, 200)];
  return cell;
}

@end
