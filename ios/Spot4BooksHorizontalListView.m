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
  
}


- (instancetype)init
{
  if ((self = [super init])) {
        /*_itemsArray = [[BooksData alloc] init];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 1" withWidth:150. andHeight:180.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 2" withWidth:120. andHeight:120.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 3" withWidth:250. andHeight:190.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 4" withWidth:170. andHeight:130.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 5" withWidth:230. andHeight:100.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 6" withWidth:350. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 7" withWidth:150. andHeight:170.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 8" withWidth:100. andHeight:40.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 9" withWidth:180. andHeight:90.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 10" withWidth:190. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 11" withWidth:100. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 12" withWidth:100. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 13" withWidth:100. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 14" withWidth:100. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 15" withWidth:100. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 16" withWidth:100. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 17" withWidth:100. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 18" withWidth:100. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 19" withWidth:100. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 20" withWidth:100. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 21" withWidth:100. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 22" withWidth:100. andHeight:140.]];
    [_itemsArray addObject:[[SimpleItemObject alloc] initWithProperties:@"Item 23" withWidth:100. andHeight:140.]];*/
    
    
  }
  return self;
}

- (void) initCollection {
  if (_collectionView==nil) {
    UICollectionViewFlowLayout* flowLayout = [[UICollectionViewFlowLayout alloc] init];
    [flowLayout setItemSize:CGSizeMake(200, 200)];
    [flowLayout setScrollDirection:UICollectionViewScrollDirectionHorizontal];
    _collectionView = [[UICollectionView alloc] initWithFrame:self.frame collectionViewLayout:flowLayout];
    [_collectionView registerClass:[Spot4BooksCell class] forCellWithReuseIdentifier:@"Spot4BooksCell"];
    [_collectionView setBackgroundColor:[UIColor clearColor]];
    [_collectionView setDelegate:self];
    [_collectionView setDataSource:self];
    [self addSubview:_collectionView];
  }
}


- (void)reactSetFrame:(CGRect)frame
{
  [super reactSetFrame: frame];
  if (_collectionView!=nil) {
    [_collectionView setFrame:frame];
  }
}


- (NSInteger)collectionView:(UICollectionView *)collectionView numberOfItemsInSection:(NSInteger)section {
  
  return [self._itemsArray count];
}


- (CGSize)collectionView:(UICollectionView *)collectionView layout:(UICollectionViewLayout*)collectionViewLayout sizeForItemAtIndexPath:(NSIndexPath *)indexPath{
  SimpleItemObject* obj = [self._itemsArray objectAtIndex:indexPath.item];
  return CGSizeMake(170., self.frame.size.height);
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
  UIView* rootView = (UIView *)[cell viewWithTag:99];
  UILabel* label = (UILabel *)[rootView viewWithTag:100];
  SimpleItemObject* obj = [self._itemsArray objectAtIndex:indexPath.item];
  NSLog(@"---------222222----%@",obj.labelText);
  [label setText:obj.labelText];
  [cell setRealBounds:CGSizeMake(170., 170.)];
  return cell;
}

@end
